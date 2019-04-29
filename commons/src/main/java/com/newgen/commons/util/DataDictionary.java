package com.newgen.commons.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jalo Deng
 * @email 651379728@qq.com
 * @date 2019-04-28 16:55
 */

public class DataDictionary {

	public static enum ActivityStatusType {
		NEW("新建", 0), 
		CHECKING("审核中", 1),
		PASSED("审核通过", 2),
		SIGNUP("报名中", 3),
		CLOSED("活动结束", -1);
		
		private final String description;
		private final Integer value;
		
		private ActivityStatusType(String description, Integer value) {
			this.description = description;
			this.value = value;
		}
		
		public String getDescription() {
			return this.description;
		}
		
		public Integer getValue() {
			return this.value;
		}
		
	}
	
	public static List<Map<String, Object>> getActivityStatusTypeValues() {
		List<Map<String, Object>> list = new ArrayList<>();
		for (ActivityStatusType type : ActivityStatusType.values()) {
			Map<String, Object> result = new HashMap<>();
			result.put("value", type.getValue());
			result.put("description", type.getDescription());
			list.add(result);
		}
		return list;
	}
	
}
