package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getAllUsers")
    public List<UserDto> getAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/getAllUsersOfPages")
    public Page<UserDto> getAllUsers(int page, int size) {
        return userService.findAllUsers(page, size);
    }

    @PostMapping("/saveUser")
    public ResponseEntity<UserDto> saveUser(@RequestBody UserDto user) {
        UserDto createdUser = userService.saveUser(user);
        return ResponseEntity.ok(createdUser);
    }

    @GetMapping("/getUserInfo")
    public ResponseEntity<UserDto> findUserById(
            @RequestParam(name = "id", required = false, defaultValue = "-1") Long id,
            @RequestParam(name = "name", required = false) String name) {
        UserDto createdUser = userService.findUserById(id);
        return ResponseEntity.ok(createdUser);
    }

    /**
     * 更新用户信息
     * @return
     */
    @PostMapping("/updateUserInfo")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto user) {
        UserDto userDto = userService.updateUser(user);
        return ResponseEntity.ok(userDto);
    }

    // 这里可以添加更多的处理HTTP请求的方法
}