package com.newgen.commons.mapper;

import com.newgen.commons.bean.ActivitySponsor;

/**
 * @author Jalo Deng
 * @email 651379728@qq.com
 * @time 2019-4-26 10:38
 */

public interface ActivitySponsorMapper extends BaseMapper<ActivitySponsor> {

	public Integer countByName(ActivitySponsor activitySponsor);
	
}
