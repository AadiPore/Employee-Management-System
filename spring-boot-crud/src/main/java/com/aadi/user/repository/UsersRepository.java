package com.aadi.user.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.aadi.user.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
    List<Users> findByName(String name);
}