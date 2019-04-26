package com.newgen.commons.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.newgen.commons.bean.ActivityPackage;

/**
 * @author Jalo Deng
 * @email 651379728@qq.com
 * @time 2019年4月19日 上午10:38:59
 */

public interface ActivityPackageMapper extends BaseMapper<ActivityPackage> {
	
	@Select("select ap.* from t_activity_package ap where ap.activityId = #{activityId}")
	public List<ActivityPackage> findByActivityId(@Param("activityId") Long activityId);
	
	@Select("select ap.id from t_activity_package ap where ap.activityId = #{activityId}")
	public List<Long> findIdByActivityId(@Param("activityId") Long activityId);
}
