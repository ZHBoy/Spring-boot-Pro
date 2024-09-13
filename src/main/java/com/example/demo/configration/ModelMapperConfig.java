package com.example.demo.configration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;  
import org.springframework.context.annotation.Configuration;

/**
 * ModelMapper-数据转换-实体类
 */
@Configuration  
public class ModelMapperConfig {  
  
    @Bean  
    public ModelMapper modelMapper() {  
        return new ModelMapper();  
    }  
}