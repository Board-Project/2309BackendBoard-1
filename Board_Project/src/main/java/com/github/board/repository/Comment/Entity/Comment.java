package com.github.board.repository.Comment.Entity;

import com.github.board.entity.Post;
import com.github.board.repository.Users.UserEntity;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
@Where(clause = "is_deleted= false")
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "user_id")
    private Integer user_id;



    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;


    @Column(name = "cmt_content",nullable = false,length = 200)
    private String content;


    @Column(name = "create_time",nullable = true)
    private LocalDateTime createTime;

    @Column(name = "is_deleted")
    private boolean isDeleted = false;


    @Column(name = "author",nullable = false,length = 32)
    private String author;




}
