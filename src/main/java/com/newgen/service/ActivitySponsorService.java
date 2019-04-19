package com.newgen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newgen.bean.ActivitySponsor;
import com.newgen.mapper.ActivitySponsorMapper;
import com.newgen.mapper.BaseMapper;

/**
 * @author Jalo Deng
 * @email 651379728@qq.com
 * @time 2019年4月19日 上午10:38:59
 */

@Service
public class ActivitySponsorService extends BaseService<ActivitySponsor> {

	@Autowired
	private ActivitySponsorMapper activitySponsorMapper;

	@Override
	public BaseMapper<ActivitySponsor> getMapper() {
		return this.activitySponsorMapper;
	}
}
