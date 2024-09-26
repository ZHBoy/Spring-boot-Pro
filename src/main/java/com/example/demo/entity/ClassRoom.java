package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Data
@Entity
@Table(name = "classes", schema = "college")
@TableName("classes")
public class ClassRoom {

    @org.springframework.data.annotation.Id
    @Column(name = "id")
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "class_id", nullable = false)
    private String classId;

    @Column(name = "class_name", nullable = false)
    private String className;

    @Column(name = "grade", nullable = false)
    private Integer grade;

    @Column(name = "head_teacher", length = 100)
    private String headTeacher;

    @Lob
    @Column(name = "description")
    private String description;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "create_at")
    private Instant createAt;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "update_at")
    private Instant updateAt;

}