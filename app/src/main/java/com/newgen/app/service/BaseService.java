package com.newgen.app.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newgen.app.mapper.BaseMapper;

/**
 * @author Jalo Deng
 * @email 651379728@qq.com
 * @time 2019年4月19日 上午10:38:59
 */

@Service
public class BaseService<T> {

	@Autowired
	public BaseMapper<T> baseMapper;
	
	public void add(T t) throws Exception {
		baseMapper.add(t);
	}

	public boolean update(T t) {
		try {
			baseMapper.update(t);
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
				baseMapper.delete(id);
			}

		}
	}

	public T queryById(Object id) throws Exception {
		return baseMapper.queryById(id);
	}
	
	public List<T> findList(Map<String, Object> var1) throws Exception {
		ifPaging(var1);
		return baseMapper.findList(var1);
	}
	
	public List<Map<?, ?>> findListMap(Map<String, Object> var1) throws Exception {
		ifPaging(var1);
		return baseMapper.findListMap(var1);
	}
	
	public int count(Map<String, Object> var1)  throws Exception {
		return baseMapper.count(var1);
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
