package com.newgen.commons.mapper;

import java.util.List;
import java.util.Map;

/**
 * @author Jalo Deng
 * @email 651379728@qq.com
 * @date 2019-04-25 14:46
 */

public interface BaseMapper<T> {

	public Integer add(T t);

	public Integer update(T t);

	public Integer delete(Object object);

	public List<T> findPageList(Map<String, Object> params);

	public List<T> findList(Map<String, Object> params);

	public List<Map<?, ?>> findListMap(Map<String, Object> params);

	public List<T> findAll();

	public T queryById(Object id);
	
	public T findById(Object id);

	public T findByBean(Object object);

	public T findByOneCondition(Object object);

	public T findByMap(Map<String, Object> params);
	
	public Integer count(Map<String, Object> params);

}
