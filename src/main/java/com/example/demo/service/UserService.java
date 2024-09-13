package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import org.springframework.data.domain.Page;

import java.util.List;  

public interface UserService {

    List<UserDTO> findAllUsers();

    Page<UserDTO> findAllUsers(int page, int size);

    UserDTO saveUser(UserDTO user);

    UserDTO findUserById(Long id);

    UserDTO updateUser(UserDTO user);


}