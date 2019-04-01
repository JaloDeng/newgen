package com.newgen.mapper;

import java.util.List;
import java.util.Map;

public interface BaseMapper<T> {
	void add(T var1);

	void update(T var1);

	void delete(Object var1);

	List<T> findPageList(Map<String, Object> var1);

	List<T> findList(Map<String, Object> var1);

	List<T> findAll();

	T queryById(Object var1);

	T findByBean(Object var1);

	T findByOneCondition(Object var1);

	T findByMap(Map<String, Object> var1);
	
	Integer count(Map<String, Object> var1);
}
