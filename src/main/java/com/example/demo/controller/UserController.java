package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    public List<UserDTO> getAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/getAllUsersOfPages")
    public Page<UserDTO> getAllUsers(int page, int size) {
        return userService.findAllUsers(page, size);
    }


    @GetMapping("/findAllUsersByMybatis")
    public List<UserDTO> findAllUsersByMybatis() {
        return userService.findAllUsersByMybatis();
    }

    @GetMapping("/findAllUsersByMybatisOfPages")
    public PageInfo<UserDTO> findAllUsersByMybatisOfPages(int page, int size) {
        return userService.findAllUsersByMybatis(page, size);
    }

    @PostMapping("/saveUser")
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO user) {
        UserDTO createdUser = userService.saveUser(user);
        return ResponseEntity.ok(createdUser);
    }

    @GetMapping("/getUserInfo")
    public ResponseEntity<UserDTO> findUserById(
            @RequestParam(name = "id", required = false, defaultValue = "-1") Long id,
            @RequestParam(name = "name", required = false) String name) {
        UserDTO createdUser = userService.findUserById(id);
        return ResponseEntity.ok(createdUser);
    }

    /**
     * 更新用户信息
     * @return
     */
    @PostMapping("/updateUserInfo")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO user) {
        UserDTO userDto = userService.updateUser(user);
        return ResponseEntity.ok(userDto);
    }

    // 这里可以添加更多的处理HTTP请求的方法
}