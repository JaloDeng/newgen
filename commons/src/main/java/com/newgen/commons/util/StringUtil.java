package com.newgen.commons.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author Jalo Deng
 * @email 651379728@qq.com
 * @date 2019-04-28 11:14
 */

public class StringUtil {

	public static String getDateId() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return sdf.format(new Date());
	}
	
	public static String getUUID() {
		return UUID.randomUUID().toString();
	}
}
