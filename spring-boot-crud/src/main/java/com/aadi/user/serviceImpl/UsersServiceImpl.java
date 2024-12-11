package com.aadi.user.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aadi.user.dto.UsersDto;
import com.aadi.user.entity.Users;
import com.aadi.user.repository.UsersRepository;
import com.aadi.user.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService{

	@Autowired
	private UsersRepository usersRepository;

	public List<UsersDto> findAll(){
		List<Users> users=usersRepository.findAll();
		List<UsersDto> usersDtos=new ArrayList<UsersDto>();
		usersDtos=users.stream().map(u->toDTO(u)).collect(Collectors.toList());
		return usersDtos;
	}
	
	public void save(UsersDto usersDto) {
		Users users=new Users();
		BeanUtils.copyProperties(usersDto, users);
		usersRepository.save(users);
	}

	public void delete(Long id) {
	    Users users = usersRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	    usersRepository.deleteById(users.getId());
	}
	
	public UsersDto findById(Long id) {
		Users users = usersRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		return toDTO(users);
	}
	
	public UsersDto toDTO(Users user) {
		UsersDto usersDto=new UsersDto();
		BeanUtils.copyProperties(user, usersDto);
		return usersDto;
	}
}