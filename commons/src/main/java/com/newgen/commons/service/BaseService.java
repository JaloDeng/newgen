package com.newgen.commons.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newgen.commons.mapper.BaseMapper;

/**
 * @author Jalo Deng
 * @email 651379728@qq.com
 * @date 2019-04-25 14:47
 */

@Service
public class BaseService<T> {

	@Autowired
	private BaseMapper<T> baseMapper;
	
	public void add(T t) throws Exception {
		baseMapper.add(t);
	}

	public boolean update(T t) {
		try {
			baseMapper.update(t);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public void delete(Object... ids) throws Exception {
		if (ids != null && ids.length >= 1) {
			Object[] idsArray = ids;
			int idsLength = ids.length;

			for (int i = 0; i < idsLength; ++i) {
				Object id = idsArray[i];
				baseMapper.delete(id);
			}

		}
	}

	public T queryById(Object id) throws Exception {
		return baseMapper.queryById(id);
	}
	
	public T findById(Object id) throws Exception {
		return baseMapper.findById(id);
	}
	
	public List<T> findList(Map<String, Object> params) throws Exception {
		ifPaging(params);
		return baseMapper.findList(params);
	}
	
	public List<Map<?, ?>> findListMap(Map<String, Object> params) throws Exception {
		ifPaging(params);
		return baseMapper.findListMap(params);
	}
	
	public int count(Map<String, Object> params)  throws Exception {
		return baseMapper.count(params);
	}
	
	private void ifPaging(Map<String, Object> params) {
		if (params.containsKey("page") && params.containsKey("row") && params.get("page") != null && params.get("row") != null) {
			try {
				Integer row = Integer.valueOf(params.get("row").toString());
				Integer index = (Integer.valueOf(params.get("page").toString()) - 1) * row;
				params.put("index", index);
			} catch (Exception e) {
				
			}
		}
	}
}