package com.github.board.repository.Posts;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@Entity
@Getter
@Setter

@NoArgsConstructor
@Table(name = "post")
public class Post {



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


}
