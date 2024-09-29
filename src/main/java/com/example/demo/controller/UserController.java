package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.service.RedisService;
import com.example.demo.service.user.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    private final RedisService redisService;

    @Autowired
    public UserController(UserService userService, RedisService redisService) {
        this.userService = userService;
        this.redisService = redisService;
    }

    @GetMapping("/getAllUsers")
    public List<UserDTO> getAllUsers() {
        setToken();
        return userService.findAllUsers();
    }

    @GetMapping("/getAllUsersOfPages")
    public Page<UserDTO> getAllUsers(int page, int size) {
        return userService.findAllUsers(page, size);
    }


    @GetMapping("/findUserByTeacher2")
    public List<UserDTO> findUsersByTeacher(String teacher) {
        return userService.findUserByTeacher2(teacher);
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
     *
     * @return
     */
    @PostMapping("/updateUserInfo")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO user) {
        UserDTO userDto = userService.updateUser(user);
        return ResponseEntity.ok(userDto);
    }

    // 这里可以添加更多的处理HTTP请求的方法

    /**
     * 设置token 使用redis
     */
    private void setToken() {

        //获取token
        String token = getToken();

        if (token == null || token.isEmpty()) {
            // 生成一个基于随机数的UUID
            UUID uuid = UUID.randomUUID();
            // 转换为字符串形式，用于显示或存储
            String uuidString = uuid.toString();
            redisService.setKey("token", uuidString);
            System.out.println("token 生成：" + uuidString);
        } else {
            System.out.println("token 已生成：" + token);
        }

    }

    private String getToken() {
        return redisService.getKey("token");
    }
}