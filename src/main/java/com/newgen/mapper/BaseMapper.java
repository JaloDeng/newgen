package com.newgen.mapper;

import java.util.List;
import java.util.Map;

/**
 * @author Jalo Deng
 * @email 651379728@qq.com
 * @time 2019年4月19日 上午10:38:59
 */

public interface BaseMapper<T> {
	void add(T var1);

	void update(T var1);

	void delete(Object var1);

	List<T> findPageList(Map<String, Object> var1);

	List<T> findList(Map<String, Object> var1);

	List<Map<?, ?>> findListMap(Map<String, Object> var1);

	List<T> findAll();

	T queryById(Object var1);

	T findByBean(Object var1);

	T findByOneCondition(Object var1);

	T findByMap(Map<String, Object> var1);
	
	Integer count(Map<String, Object> var1);

}
