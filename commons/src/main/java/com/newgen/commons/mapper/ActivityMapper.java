package com.newgen.commons.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.newgen.commons.bean.Activity;

/**
 * @author Jalo Deng
 * @email 651379728@qq.com
 * @time 2019年4月19日 上午10:38:59
 */

public interface ActivityMapper extends BaseMapper<Activity> {
	
	public Integer updateStatusById(@Param("id") Long id, @Param("status") Integer status, @Param("updateTime") Date updateTime);

	public Integer countByTitle(Activity activity);
	
	public List<Map<String, Object>> findByConditions(Map<String, Object> params);
	
	public Integer findCountByConditions(Map<String, Object> params);
}
