package com.example.demo.service.educator;

import com.example.demo.dao.EducatorRepository;
import com.example.demo.dto.EducatorDTO;
import com.example.demo.entity.Educator;
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
public class EducatorServiceImpl implements EducatorService {

    private final ModelMapper modelMapper;

    private final EducatorRepository educatorRepository;

    @Autowired
    public EducatorServiceImpl(EducatorRepository educatorRepository, ModelMapper modelMapper) {
        this.educatorRepository = educatorRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<EducatorDTO> findAllEducator() {
        List<Educator> userList = educatorRepository.findAll();
        return modelMapper.map(userList, new TypeToken<List<EducatorDTO>>() {
        }.getType());
    }

    @Override
    public Page<EducatorDTO> findAllEducator(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "age")); // page从0开始，size是每页的数量
        Page<Educator> page1 = educatorRepository.findAll(pageable);

        System.out.println("是否第一页: " + page1.isFirst());
        System.out.println("是否最后一页: " + page1.isLast());
        System.out.println("总页码数: " + page1.getTotalPages());
        System.out.println("总条目数: " + page1.getTotalElements());
        System.out.println("当前页码: " + page1.getNumber());
        System.out.println("当前页条目数量: " + page1.getSize());

        return modelMapper.map(page1, new TypeToken<Page<EducatorDTO>>() {
        }.getType());
    }

    @Override
    public EducatorDTO saveEducator(EducatorDTO educatorDTO) {
        Educator educator = modelMapper.map(educatorDTO, Educator.class);
        return modelMapper.map(educatorRepository.save(educator), EducatorDTO.class);
    }

    @Override
    public EducatorDTO findEducatorById(Long id) {
        return modelMapper.map(educatorRepository.findById(id), EducatorDTO.class);

    }

    @Override
    public EducatorDTO updateEducator(EducatorDTO educatorDTO) {
        // 假设UserDetails是一个包含新信息的DTO或仅仅是一个包含要更新字段的Map
        Educator userOrigin = educatorRepository.findById(educatorDTO.getId())
                .orElseThrow(() -> new RuntimeException("User not found with id " + educatorDTO.getId()));

        // 更新用户信息
        userOrigin.setUserId(educatorDTO.getUserId());
        userOrigin.setName(educatorDTO.getName());
        userOrigin.setEmail(educatorDTO.getEmail());
        userOrigin.setAge(educatorDTO.getAge());
        userOrigin.setSex(educatorDTO.getSex());
        userOrigin.setIntroduction(educatorDTO.getIntroduction());
        userOrigin.setCollage(educatorDTO.getCollage());
        userOrigin.setAcademicTitle(educatorDTO.getAcademicTitle());

        Educator currentUser = educatorRepository.save(userOrigin);
        return modelMapper.map(currentUser, EducatorDTO.class);
    }
}