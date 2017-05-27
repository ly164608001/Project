package com.tgb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tgb.mapper.TUserMapper;
import com.tgb.model.TUser;
import com.tgb.service.ITUserService;

/**
 * TUser涓氬姟閫昏緫灞傚疄鐜扮被
 * @author 
 * @date   2017-05-27
 */ 
@Service
public class TUserServiceImpl implements ITUserService {
	@Autowired
	private TUserMapper tUserMapper;
	 
	@Override
	public TUser insert(TUser entity) {
		return tUserMapper.insert(entity);
	}

	@Override
	public TUser update(TUser entity) {
		return tUserMapper.update(entity);
	}

	@Override
	public void delete(String id) {
		tUserMapper.delete(id);
	}

	@Override
	public TUser queryOne(String id) {
		return tUserMapper.queryOne(id);
	}
	
}