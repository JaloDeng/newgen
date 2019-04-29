package com.newgen.commons.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.newgen.commons.bean.Activity;
import com.newgen.commons.mapper.ActivityMapper;
import com.newgen.commons.mapper.ActivityPackageMapper;
import com.newgen.commons.model.Result;
import com.newgen.commons.util.DataDictionary.ActivityStatusType;
import com.newgen.commons.util.StringUtil;

/**
 * @author Jalo Deng
 * @email 651379728@qq.com
 * @time 2019年4月19日 上午10:38:59
 */

@Service
public class ActivityService extends BaseService<Activity> {

	private static final Logger LOGGER = LoggerFactory.getLogger(ActivityService.class);
	
	@Autowired
	private ActivityMapper activityMapper;
	
	@Autowired
	private ActivityPackageMapper activityPackageMapper;
	
	/**
	 * 保存活动，t_activity和t_activity_package表
	 * <br>1: 有ID为更新，没有ID为新增
	 * @param activity
	 * @return
	 * @throws Exception
	 */
	@Transactional
	public Result save(Activity activity) throws Exception {
		List<String> oldActivityPackageIds = new ArrayList<>();
		List<String> newActivityPackageIds = new ArrayList<>();
		activity.setUpdateTime(new Date());
		String msg = "修改成功";
		Integer countByTitle = activityMapper.countByTitle(activity);
		// 新增或者更新t_activity表
		if (StringUtils.isEmpty(activity.getId())) {
			if (countByTitle > 0) {
				LOGGER.error(String.format("添加失败，活动主题已存在 :  title=[%s]", activity.getTitle()));
				return new Result(0, String.format("添加失败，活动主题[%s]已存在", activity.getTitle()), null);
			}
			activity.setId(StringUtil.getDateId());
			activity.setCreateTime(new Date());
			activityMapper.add(activity);
			msg = "新增成功";
		} else {
			if (countByTitle > 1) {
				LOGGER.error(String.format("修改失败，活动主题已存在 :  title=[%s]", activity.getTitle()));
				return new Result(0, String.format("修改失败，活动主题[%s]已存在", activity.getTitle()), null);
			}
			oldActivityPackageIds = activityPackageMapper.findIdByActivityId(activity.getId());
			super.update(activity);
		}
		// 新增或更新t_activity_package表
		activity.getActivityPackages().stream().forEach(activityPackage -> {
			newActivityPackageIds.add(activityPackage.getId());
			activityPackage.setActivityId(activity.getId());
			activityPackage.setUpdateTime(new Date());
			if (StringUtils.isEmpty(activityPackage.getId())) {
				activityPackage.setId(StringUtil.getDateId());
				activityPackage.setCreateTime(new Date());
				activityPackageMapper.add(activityPackage);
			} else {
				activityPackageMapper.update(activityPackage);
			}
		});
		// 前端没有提交的id与数据库对比，没有则删除
		oldActivityPackageIds.stream().forEach(id -> {
			if (!newActivityPackageIds.contains(id)) {
				activityPackageMapper.delete(id);
			}
		});
		
		return new Result(1, msg, null);
	}
	
	/**
	 * 更改活动表状态 t_activity.status
	 * @param id 主键ID, t_activity.id
	 * @param activityStatusType 0:新建 1:审核中 2:审核通过 3:报名中 -1:报名结束
	 */
	@Transactional
	public void updateStatusById(String id, ActivityStatusType activityStatusType) throws Exception {
		Integer count = activityMapper.updateStatusById(id, activityStatusType.getValue(), new Date());
		if (count != 1) {
			throw new RuntimeException("修改条数不是一条");
		}
	}
}
