package com.github.board.repository.PostTest;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "post_test")
public class PostTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK, AutoIncrement
    @Column(name = "id")
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;
    @Column(name = "author")
    private String author;
    @Column(name = "create_time")
    private LocalDateTime createTime;
}

