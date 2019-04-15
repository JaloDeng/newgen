package com.newgen.service;

import java.util.List;
import java.util.Map;

import com.newgen.mapper.BaseMapper;

public abstract class BaseService<T> {

	public abstract BaseMapper<T> getMapper();
	
	public void add(T t) throws Exception {
		this.getMapper().add(t);
	}

	public boolean update(T t) {
		try {
			this.getMapper().update(t);
			return true;
		} catch (Exception var3) {
			var3.printStackTrace();
			return false;
		}
	}

	public void delete(Object... ids) throws Exception {
		if (ids != null && ids.length >= 1) {
			Object[] var5 = ids;
			int var4 = ids.length;

			for (int var3 = 0; var3 < var4; ++var3) {
				Object id = var5[var3];
				this.getMapper().delete(id);
			}

		}
	}

	public T queryById(Object id) throws Exception {
		return this.getMapper().queryById(id);
	}
	
	public List<T> findList(Map<String, Object> var1) throws Exception {
		ifPaging(var1);
		return this.getMapper().findList(var1);
	}
	
	public List<Map<?, ?>> findListMap(Map<String, Object> var1) throws Exception {
		ifPaging(var1);
		return this.getMapper().findListMap(var1);
	}
	
	public int count(Map<String, Object> var1)  throws Exception {
		return findList(var1).size();
	}
	
	private void ifPaging(Map<String, Object> var1) {
		if (var1.containsKey("page") && var1.containsKey("row") && var1.get("page") != null && var1.get("row") != null) {
			try {
				Integer row = Integer.valueOf(var1.get("row").toString());
				Integer index = (Integer.valueOf(var1.get("page").toString()) - 1) * row;
				var1.put("index", index);
			} catch (Exception e) {
				
			}
		}
	}
}
