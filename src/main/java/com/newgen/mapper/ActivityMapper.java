package com.newgen.mapper;

import java.util.List;
import java.util.Map;

import com.newgen.bean.Activity;

public interface ActivityMapper extends BaseMapper<Activity> {
	
	List<Map<?, ?>> findListForSearch(Map<String, Object> var1);
}
