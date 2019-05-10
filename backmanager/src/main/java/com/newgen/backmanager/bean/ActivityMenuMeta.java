package com.newgen.backmanager.bean;

import java.io.Serializable;

/**
 * @author Jalo Deng
 * @email 651379728@qq.com
 * @date 2019-05-07 16:37
 */

public class ActivityMenuMeta implements Serializable {

	private static final long serialVersionUID = 2468684496158846964L;

	private boolean keepAlive;
	
	private boolean requireAuth;

	public boolean isKeepAlive() {
		return keepAlive;
	}

	public void setKeepAlive(boolean keepAlive) {
		this.keepAlive = keepAlive;
	}

	public boolean isRequireAuth() {
		return requireAuth;
	}

	public void setRequireAuth(boolean requireAuth) {
		this.requireAuth = requireAuth;
	}
	
}
