package com.newgen.commons.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.newgen.commons.bean.Activity;
import com.newgen.commons.mapper.ActivityMapper;
import com.newgen.commons.mapper.ActivityPackageMapper;
import com.newgen.commons.model.Result;

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
	
	@SuppressWarnings("unchecked")
	@Transactional
	public Result save(Activity activity) throws Exception {
		List<Long> oldActivityPackageIds = new ArrayList<>();
		List<Long> newActivityPackageIds = new ArrayList<>();
		activity.setUpdateTime(new Date());
		Boolean isNew = false;
		if (activity.getId() != null) {
			oldActivityPackageIds = activityPackageMapper.findIdByActivityId(activity.getId());
			super.update(activity);
		} else {
			ObjectMapper om = new ObjectMapper();
			if (super.count(om.convertValue(activity, Map.class)) > 0 ) {
				LOGGER.error(String.format("添加失败，活动主题已存在 :  title=[%s]", activity.getTitle()));
				return new Result(0, String.format("添加失败，活动主题[%s]已存在", activity.getTitle()), null);
			}
			activity.setCreateTime(new Date());
			Long newId = activityMapper.addAndGetId(activity);
			isNew = true;
			activity.setId(newId);
		}
		activity.getActivityPackages().stream().forEach(activityPackage -> {
			newActivityPackageIds.add(activityPackage.getId());
			activityPackage.setActivityId(activity.getId());
			activityPackage.setUpdateTime(new Date());
			if (activityPackage.getId() != null) {
				activityPackageMapper.update(activityPackage);
			} else {
				activityPackage.setCreateTime(new Date());
				activityPackageMapper.add(activityPackage);
			}
		});
		oldActivityPackageIds.stream().forEach(id -> {
			if (!newActivityPackageIds.contains(id)) {
				activityPackageMapper.delete(id);
			}
		});
		if (!isNew) {
			return new Result(1, "修改成功", null);
		} else {
			return new Result(1, "添加成功", null);
		}
	}
	
}
