package com.newgen.backmanager.mapper;

import com.newgen.backmanager.bean.Admin;
import com.newgen.commons.mapper.BaseMapper;

/**
 * @author Jalo Deng
 * @email 651379728@qq.com
 * @date 2019-05-05 09:48
 */

public interface AdminMapper extends BaseMapper<Admin> {

	public Admin findByUserName(String username);
}
