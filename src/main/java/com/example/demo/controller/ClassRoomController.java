package com.example.demo.controller;

import com.example.demo.dto.ClassRoomDTO;
import com.example.demo.dto.EducatorDTO;
import com.example.demo.service.classroom.ClassRoomService;
import com.example.demo.service.educator.EducatorService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/class")
public class ClassRoomController {

    private final ClassRoomService classRoomService;

    @Autowired
    public ClassRoomController(ClassRoomService classRoomService) {
        this.classRoomService = classRoomService;
    }

    @GetMapping("/findAllClassRoom")
    public List<ClassRoomDTO> getAllClassRooms() {
        return classRoomService.findAllClassRoom();
    }

    @GetMapping("/findAllClassRoomOfPages")
    public PageInfo<ClassRoomDTO> findAllClassRoomOfPages(int page, int size) {
        return classRoomService.findAllClassRoom(page, size);
    }

    @PostMapping("/saveClassRoom")
    public ResponseEntity<Integer> saveClassRoom(@RequestBody ClassRoomDTO classRoomDTO) {
        int i = classRoomService.saveClassRoom(classRoomDTO);
        return ResponseEntity.ok(i);
    }

    @GetMapping("/findClassRoomById")
    public ResponseEntity<ClassRoomDTO> findClassRoomById(
            @RequestParam(name = "id", required = false, defaultValue = "-1") Long id,
            @RequestParam(name = "className", required = false) String name) {
        ClassRoomDTO classRoomDTO = classRoomService.findClassRoomById(id);
        return ResponseEntity.ok(classRoomDTO);
    }

    /**
     * 更新用户信息
     *
     * @return
     */
    @PostMapping("/updateUserInfo")
    public ResponseEntity<Integer> updateClassRoom(@RequestBody ClassRoomDTO classRoomDTO) {
        int status = classRoomService.updateClassRoom(classRoomDTO);
        return ResponseEntity.ok(status);
    }

    // 这里可以添加更多的处理HTTP请求的方法
}