package com.tgb.service;

import com.tgb.model.BaseEntity;


public interface IBaseService<T extends BaseEntity> {
	T insert(T entity);
	T update(T entity);
	void delete(String id);
	T queryOne(String id);
}
