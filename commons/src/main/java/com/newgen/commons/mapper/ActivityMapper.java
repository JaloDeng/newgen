package com.newgen.commons.mapper;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import com.newgen.commons.bean.Activity;

/**
 * @author Jalo Deng
 * @email 651379728@qq.com
 * @time 2019年4月19日 上午10:38:59
 */

public interface ActivityMapper extends BaseMapper<Activity> {
	
	public Integer updateStatusById(@Param("id") String id, @Param("status") Integer status, @Param("updateTime") Date updateTime);

	public Integer countByTitle(Activity activity);
}