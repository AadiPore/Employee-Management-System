package com.cato.core.billing.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cato.core.billing.common.security.data.UserDetail;

@Repository
public interface UserDetailRepository extends JpaRepository<UserDetail, Long>{

	UserDetail findByUsername(String username);
}
