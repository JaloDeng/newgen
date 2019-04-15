package com.newgen.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newgen.bean.Activity;
import com.newgen.mapper.ActivityMapper;
import com.newgen.mapper.BaseMapper;

@Service
public class ActivityService extends BaseService<Activity> {

	@Autowired
	private ActivityMapper activityMapper;
	
	@Override
	public BaseMapper<Activity> getMapper() {
		return this.activityMapper;
	}
	
	public List<Map<?, ?>> findListForSearch(Integer page, Integer row) {
		Map<String, Object> params = new HashMap<String, Object>();
		if (page != null && row != null) {
			params.put("index", (page - 1)*row);
			params.put("row", row);
		}
		return activityMapper.findListForSearch(params);
	}
	
}
