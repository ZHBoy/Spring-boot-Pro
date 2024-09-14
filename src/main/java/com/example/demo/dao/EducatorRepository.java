package com.example.demo.dao;

import com.example.demo.entity.Educator;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducatorRepository extends JpaRepository<Educator, Long> {
    // 这里继承JpaRepository已经提供了很多常用的方法，如findAll, save, delete等  
    // 如果需要自定义查询，可以在这里添加方法声明  
}