package com.aadi.user.service;

import java.util.List;

import com.aadi.user.dto.UsersDto;

public interface UsersService {
	
	List<UsersDto> findAll();
	
	void save(UsersDto usersDto);
	
	void delete(Long id);
	
	UsersDto findById(Long id);
}