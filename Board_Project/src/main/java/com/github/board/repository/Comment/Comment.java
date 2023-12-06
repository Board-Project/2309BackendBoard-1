package com.github.board.repository.Comment;

import com.github.board.repository.Posts.Post;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    @Column(name = "cmt_content",nullable = false,length = 200)
    private String content;

    @Column(name = "create_time",nullable = true)
    private LocalDateTime createTime;

    @Column(name = "author",nullable = false,length = 32)
    private String author;

}
