package com.newgen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newgen.bean.ActivitySponsor;
import com.newgen.mapper.ActivitySponsorMapper;
import com.newgen.mapper.BaseMapper;

@Service
public class ActivitySponsorService extends BaseService<ActivitySponsor> {

	@Autowired
	private ActivitySponsorMapper activitySponsorMapper;

	@Override
	public BaseMapper<ActivitySponsor> getMapper() {
		return this.activitySponsorMapper;
	}
}
