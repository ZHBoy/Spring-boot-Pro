package com.example.demo.service.classroom;

import com.example.demo.dto.ClassRoomDTO;
import com.example.demo.dto.ClassRoomDTO;
import com.github.pagehelper.PageInfo;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ClassRoomService {

    List<ClassRoomDTO> findAllClassRoom();

    PageInfo<ClassRoomDTO> findAllClassRoom(int page, int size);

    int saveClassRoom(ClassRoomDTO user);

    ClassRoomDTO findClassRoomById(Long id);

    int updateClassRoom(ClassRoomDTO user);
}
