package com.tgb.mapper;

import com.tgb.model.BaseEntity;


public interface IBaseDao<T extends BaseEntity> {
	T insert(T entity);
	T update(T entity);
	void delete(String id);
	T queryOne(String id);
}
