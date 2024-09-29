package com.example.demo.controller;

import com.example.demo.dto.EducatorDTO;
import com.example.demo.service.educator.EducatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/educators")
public class EducatorController {

    private final EducatorService educatorService;

    @Autowired
    public EducatorController(EducatorService educatorService) {
        this.educatorService = educatorService;
    }

    @GetMapping("/getAllUsers")
    public List<EducatorDTO> getAllUsers() {
        return educatorService.findAllEducator();
    }

    @GetMapping("/getAllUsersOfPages")
    public Page<EducatorDTO> getAllUsers(int page, int size) {
        return educatorService.findAllEducator(page, size);
    }

    @PostMapping("/saveUser")
    public ResponseEntity<EducatorDTO> saveUser(@RequestBody EducatorDTO educatorDTO) {
        EducatorDTO createdUser = educatorService.saveEducator(educatorDTO);
        return ResponseEntity.ok(createdUser);
    }

    @GetMapping("/getUserInfo")
    public ResponseEntity<EducatorDTO> findUserById(
            @RequestParam(name = "id", required = false, defaultValue = "-1") Long id,
            @RequestParam(name = "name", required = false) String name) {
        EducatorDTO createdUser = educatorService.findEducatorById(id);
        return ResponseEntity.ok(createdUser);
    }

    /**
     * 更新用户信息
     *
     * @return
     */
    @PostMapping("/updateUserInfo")
    public ResponseEntity<EducatorDTO> updateUser(@RequestBody EducatorDTO user) {
        EducatorDTO userDto = educatorService.updateEducator(user);
        return ResponseEntity.ok(userDto);
    }

    // 这里可以添加更多的处理HTTP请求的方法
}