package com.example.demo.dto;

import lombok.Data;

import java.time.Instant;

@Data
public class ClassRoomDTO {
    private Integer id;

    private String classId;

    private String className;

    private Integer grade;

    private String headTeacher;

    private String description;

    private Instant createAt;

    private Instant updateAt;

}