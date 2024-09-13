package com.example.demo.service;

import com.example.demo.dao.UserRepository;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * 查询所有用户数据
     *
     * @return 所有用户数据
     */
    public List<UserDto> findAllUsers() {
        List<User> userList = userRepository.findAll();
        return modelMapper.map(userList, new TypeToken<List<UserDto>>() {
        }.getType());
    }

    /**
     * 增加用户
     *
     * @param userDto
     */
    @Override
    public UserDto saveUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        return modelMapper.map(userRepository.save(user), UserDto.class);
    }

    @Override
    public UserDto findUserById(Long id) {
        return modelMapper.map(userRepository.findById(id), UserDto.class);
    }

    @Override
    public UserDto updateUser(UserDto user) {

        // 假设UserDetails是一个包含新信息的DTO或仅仅是一个包含要更新字段的Map
        User userOrigin = userRepository.findById(user.getId())
                .orElseThrow(() -> new RuntimeException("User not found with id " + user.getId()));

        // 更新用户信息
        userOrigin.setName(user.getName());
        userOrigin.setEmail(user.getEmail());
        userOrigin.setAge(user.getAge());

        User currentUser = userRepository.save(userOrigin);
        return modelMapper.map(currentUser, UserDto.class);
    }

    @Override
    public Page<UserDto> findAllUsers(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "age")); // page从0开始，size是每页的数量
        Page<User> page1 = userRepository.findAll(pageable);

        System.out.println("是否第一页: "+page1.isFirst());
        System.out.println("是否最后一页: "+page1.isLast());
        System.out.println("总页码数: "+page1.getTotalPages());
        System.out.println("总条目数: "+page1.getTotalElements());
        System.out.println("当前页码: "+page1.getNumber());
        System.out.println("当前页条目数量: "+page1.getSize());

        return modelMapper.map(page1, new TypeToken<Page<UserDto>>() {
        }.getType());
    }

    // 这里可以添加更多的业务方法
}
