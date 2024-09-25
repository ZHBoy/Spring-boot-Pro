package com.example.demo.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "users")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@TableName("users")
public class User {
    @Id
    @Column(name = "id")
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @TableId
    private Long id;
    @Lob
    @Column(name = "user_id", nullable = false)
    private String userId;
    private String name;
    private String age;
    private String email;
    private String collage;
    private String profession;
    private String class_info;

}