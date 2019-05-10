package com.newgen.backmanager.security.config;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import com.newgen.backmanager.bean.ActivityMenu;
import com.newgen.backmanager.bean.ActivityRole;
import com.newgen.backmanager.service.ActivityMenuService;

/**
 * @author Jalo Deng
 * @email 651379728@qq.com
 * @date 2019-05-09 16:04
 */

@Component
public class CustomMetadataSource implements FilterInvocationSecurityMetadataSource {

	@Autowired
	private ActivityMenuService activityMenuService;
	
	private AntPathMatcher antPathMatcher = new AntPathMatcher();
	
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		// 获取请求地址
		String requestUrl = ((FilterInvocation) object).getRequestUrl();
		if ("/login_p".equals(requestUrl)) {
			return null;
		}
		List<ActivityMenu> activityMenus = activityMenuService.findAll();
		for (ActivityMenu activityMenu : activityMenus) {
			if (antPathMatcher.match(activityMenu.getUrl(), requestUrl) && activityMenu.getRoles().size() > 0) {
				List<ActivityRole> activityRoles = activityMenu.getRoles();
				Integer size = activityRoles.size();
				String[] values = new String[size];
				 for (int i = 0; i < size; i++) {
					 values[i] = activityRoles.get(i).getName();
				 }
				 return SecurityConfig.createList(values);
			}
		}
		return SecurityConfig.createList("ROLE_LOGIN");
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return FilterInvocation.class.isAssignableFrom(clazz);
	}

}
