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

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_index", nullable = false)
    private Post post;

    @NotNull
    @Column(name = "cmt_content",nullable = false,length = 200)
    private String content;

    @NotNull
    @Column(name = "like_cnt",nullable = false)
    private Integer like;

    @NotNull
    @Column(name = "create_time",nullable = false)
    private LocalDateTime createTime;

    @Column(name = "update_time")
    private LocalDateTime updateTime;

    @Column(name = "is_deleted")
    private boolean isDeleted = false;

    @NotNull
    @Column(name = "author",nullable = false,length = 32)
    private String author;


}
