package com.github.board.repository.Posts;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;

@AllArgsConstructor
@Entity
@Getter
@Setter
//@EqualsAndHashCode(of = "id")
//@Builder
@NoArgsConstructor
@Table(name = "post")
public class Post {

    // 게시글 user id - 댓글 참조

    @Id //primary key
    @Column(name ="id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title",length = 63, nullable = false)
    private String title;

    @Column(name = "content", length = 255, nullable = false)
    private String content;

    @Column(name = "author", length = 32, nullable = false)
    private String author;

//    @Column(name = "create_time", nullable = false)
//    private LocalDateTime create_time;


    //private String email;

}
