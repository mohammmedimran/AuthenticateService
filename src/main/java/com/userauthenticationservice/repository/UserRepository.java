package com.userauthenticationservice.repository;

import com.userauthenticationservice.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser,Integer> {
    AppUser findByUserName(String username);
}
