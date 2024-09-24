package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.github.pagehelper.PageInfo;
import org.springframework.data.domain.Page;

import java.util.List;  

public interface UserService {

    List<UserDTO> findAllUsers();

    Page<UserDTO> findAllUsers(int page, int size);

    UserDTO saveUser(UserDTO user);

    UserDTO findUserById(Long id);

    UserDTO updateUser(UserDTO user);

    List<UserDTO> findAllUsersByMybatis();

    PageInfo<UserDTO> findAllUsersByMybatis(int pageNum, int pageSize);

}