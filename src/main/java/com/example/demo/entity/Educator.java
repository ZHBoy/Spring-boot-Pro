package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "educators")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Educator {
    @org.springframework.data.annotation.Id
    @Column(name = "id")
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(name = "user_id", nullable = false)
    private String userId;

    @Lob
    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @Lob
    @Column(name = "sex")
    private String sex;

    @Lob
    @Column(name = "email")
    private String email;

    @Lob
    @Column(name = "collage")
    private String collage;

    @Lob
    @Column(name = "academic_title")
    private String academicTitle;

    @Lob
    @Column(name = "introduction")
    private String introduction;

}