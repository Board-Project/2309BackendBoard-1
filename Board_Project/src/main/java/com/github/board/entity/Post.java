package com.github.board.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Builder
@NoArgsConstructor
@Table(name = "post")
public class Post {

    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id") //
    private Integer user_id;

    @Column(name = "title",length = 63)
    private String title;

    @Column(name = "content", length = 255)
    private String content;

    @Column(name = "author", length = 32)
    private String author;

    @Column(name = "like_cnt")
    private Integer like_cnt;

    @Column(name = "visitor_cnt")
    private Integer vistor_cnt;

    @Column(name = "create_time")
    private LocalDateTime create_time;

    @Column(name = "update_time")
    private LocalDateTime update_time;



    //private String email;

}
