package com.example.demo.service.educator;

import com.example.demo.dto.EducatorDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EducatorService {

    List<EducatorDTO> findAllEducator();

    Page<EducatorDTO> findAllEducator(int page, int size);

    EducatorDTO saveEducator(EducatorDTO user);

    EducatorDTO findEducatorById(Long id);

    EducatorDTO updateEducator(EducatorDTO user);
}
