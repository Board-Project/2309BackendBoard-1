package com.github.board.repository.Users;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert      //엔티티 변화가 있는 컬럼에 대해서만 SQL 실행
@Table(name = "user")
public class UserEntity {
    @Id
    @Column(name="id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_name",nullable = false,length = 20)
    private String user_name;
    @Column(name = "email",nullable = false,length = 255)
    private String email;
    @Column(name = "password",nullable = false,length = 255)
    private String password;
    @Column(name = "create_time",nullable = false)
    private LocalDateTime create_time;



}
