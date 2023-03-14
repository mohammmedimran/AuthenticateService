package com.userauthenticationservice.service;

import com.userauthenticationservice.entity.AppUser;
import com.userauthenticationservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;
    @Override
    public AppUser saveUser(AppUser user) {
        log.info("Added new User {} UserServiceImplementation::saveUser",user.getUserName());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public Optional<AppUser> getUser(Integer id) {
        log.info("findByUserName {} UserServiceImplementation::getUser",id);
        return userRepository.findById(id);
    }

    @Override
    public List<AppUser> getAllUser() {
        log.info("findAllUser {} UserServiceImplementation::getAllUser");
        return userRepository.findAll();
    }
}
