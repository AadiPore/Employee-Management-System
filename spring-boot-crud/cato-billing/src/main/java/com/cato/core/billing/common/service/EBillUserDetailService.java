package com.cato.core.billing.common.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cato.core.billing.common.repository.UserDetailRepository;
import com.cato.core.billing.common.security.data.UserDetail;

@Service
public class EBillUserDetailService implements UserDetailsService {

	@Autowired
	UserDetailRepository userDetailRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UserDetail userDetail = userDetailRepository.findByUsername(username);

		if (userDetail == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new User(username, userDetail.getPassword(), 
				(userDetail.getEnabled().equalsIgnoreCase("y")) ? true : false, 
						true, true, true,
				Collections.emptyList());
	}
}
