package com.newgen.commons.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.newgen.commons.bean.ActivitySponsor;
import com.newgen.commons.mapper.ActivitySponsorMapper;
import com.newgen.commons.model.Result;

/**
 * @author Jalo Deng
 * @email 651379728@qq.com
 * @time 2019年4月19日 上午10:38:59
 */

@Service
public class ActivitySponsorService extends BaseService<ActivitySponsor> {

	private static final Logger LOGGER = LoggerFactory.getLogger(ActivitySponsorService.class);
	
	@Autowired
	private ActivitySponsorMapper activitySponsorMapper;
	
	@Transactional
	public Result save(ActivitySponsor activitySponsor) throws Exception {
		activitySponsor.setUpdateTime(new Date());
		if (activitySponsorMapper.countByName(activitySponsor) > 0) {
			LOGGER.error(String.format("保存失败，主办方已存在 :  name=[%s]", activitySponsor.getName()));
			return new Result(0, String.format("保存失败，主办方[%s]已存在", activitySponsor.getName()), null);
		}
		if (activitySponsor.getId() == null) {
			activitySponsor.setCreateTime(new Date());
			activitySponsorMapper.add(activitySponsor);
		} else {
			activitySponsorMapper.update(activitySponsor);
		}
		return new Result(1, "保存成功", null);
	}
}
