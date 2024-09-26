package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    List<User> findAll();

    /**
     * 选中班主任为 玲珑的 学生
     * @return 学生列表
     */
    List<User> findUserByTeacher();


    /**
     * 选中班主任为
     * @return 学生列表
     */
    List<User> findUserByTeacher2(@Param("head_teacher") String teacher);


}