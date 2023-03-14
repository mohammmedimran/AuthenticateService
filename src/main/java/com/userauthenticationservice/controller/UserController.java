package com.userauthenticationservice.controller;

import com.userauthenticationservice.entity.AppUser;
import com.userauthenticationservice.entity.AuthRequest;
import com.userauthenticationservice.service.UserService;
import com.userauthenticationservice.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("user/{id}")
    public ResponseEntity<AppUser> getUserByValidationToken(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUser(id).get());
    }
    @GetMapping("/users")
    public ResponseEntity<List<AppUser>> getAllUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUser());
    }

    @PostMapping("/user/save")
    public ResponseEntity<AppUser> saveUser(@RequestBody AppUser user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(user));
    }
}
