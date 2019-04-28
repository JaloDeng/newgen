package com.newgen.commons.service;

import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.newgen.commons.bean.ActivitySponsor;
import com.newgen.commons.model.Result;
import com.newgen.commons.util.StringUtil;

/**
 * @author Jalo Deng
 * @email 651379728@qq.com
 * @time 2019年4月19日 上午10:38:59
 */

@Service
public class ActivitySponsorService extends BaseService<ActivitySponsor> {

	private static final Logger LOGGER = LoggerFactory.getLogger(ActivitySponsorService.class);
	
	@SuppressWarnings("unchecked")
	@Transactional
	public Result save(ActivitySponsor activitySponsor) throws Exception {
		activitySponsor.setUpdateTime(new Date());
		if (activitySponsor.getId() != null && !"".equals(activitySponsor.getId())) {
			super.update(activitySponsor);
			return new Result(1, "修改成功", null);
		} else {
			ObjectMapper om = new ObjectMapper();
			if (super.count(om.convertValue(activitySponsor, Map.class)) > 0 ) {
				LOGGER.error(String.format("添加失败，主办方已存在 :  name=[%s]", activitySponsor.getName()));
				return new Result(0, String.format("添加失败，主办方[%s]已存在", activitySponsor.getName()), null);
			}
			activitySponsor.setId(StringUtil.getDateId());
			activitySponsor.setCreateTime(new Date());
			super.add(activitySponsor);
			return new Result(1, "添加成功", null);
		}
	}
}
