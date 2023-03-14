package com.userauthenticationservice.service;


import com.userauthenticationservice.entity.AppUser;

import java.util.List;
import java.util.Optional;

public interface UserService {
    AppUser saveUser(AppUser user);
    Optional<AppUser> getUser(Integer id);
    List<AppUser> getAllUser();
}
