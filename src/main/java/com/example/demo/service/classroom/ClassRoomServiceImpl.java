package com.example.demo.service.classroom;

import com.example.demo.dto.ClassRoomDTO;
import com.example.demo.entity.ClassRoom;
import com.example.demo.mapper.ClassMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassRoomServiceImpl implements ClassRoomService {

    private final ModelMapper modelMapper;

    private final ClassMapper classMapper;

    @Autowired
    public ClassRoomServiceImpl(ClassMapper classMapper, ModelMapper modelMapper) {
        this.classMapper = classMapper;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ClassRoomDTO> findAllClassRoom() {
        List<ClassRoom> classRoomList = classMapper.selectList(null);
        return modelMapper.map(classRoomList, new TypeToken<List<ClassRoomDTO>>() {
        }.getType());
    }

    @Override
    public PageInfo<ClassRoomDTO> findAllClassRoom(int pageNum, int pageSize) {

        // 使用PageHelper进行分页
        PageHelper.startPage(pageNum, pageSize);
        // 调用Mapper中的查询方法
        List<ClassRoom> classRoomList = classMapper.selectList(null);

        List<ClassRoomDTO> dtoList = modelMapper.map(classRoomList, new TypeToken<List<ClassRoomDTO>>() {
        }.getType());
        // 使用PageInfo包装查询结果，方便获取分页信息
        return new PageInfo<>(dtoList);
    }

    @Override
    public int saveClassRoom(ClassRoomDTO classRoomDTO) {
        ClassRoom classRoom = modelMapper.map(classRoomDTO, ClassRoom.class);
       int status =  classMapper.insert(classRoom);
        return status;
    }

    @Override
    public ClassRoomDTO findClassRoomById(Long id) {
        return modelMapper.map(classMapper.selectById(id), ClassRoomDTO.class);

    }

    @Override
    public int updateClassRoom(ClassRoomDTO classRoomDTO) {
        // 假设UserDetails是一个包含新信息的DTO或仅仅是一个包含要更新字段的Map
        ClassRoom classRoom = classMapper.selectById(classRoomDTO.getClassId());

        // 更新用户信息
        classRoom.setClassId(classRoomDTO.getClassId());
        classRoom.setClassName(classRoomDTO.getClassName());
        classRoom.setGrade(classRoomDTO.getGrade());
        classRoom.setDescription(classRoomDTO.getDescription());
        classRoom.setHeadTeacher(classRoomDTO.getHeadTeacher());

        int insert = classMapper.insert(classRoom);
        return insert;
    }
}