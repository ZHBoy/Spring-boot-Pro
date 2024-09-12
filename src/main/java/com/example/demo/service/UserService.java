package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
  
import java.util.List;  

public interface UserService {

    List<UserDto> findAllUsers();

    UserDto saveUser(UserDto user);
}