package com.github.board.repository.Comment.Dto;

import com.github.board.repository.Comment.Entity.Comment;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ToString
@Builder
@Getter
@Setter
@AllArgsConstructor
public class CommentDto {

    @ToString
    @Builder
    @Getter
    @Setter
    @AllArgsConstructor
    public static class CreateCommentRequest {
        private Integer postId;
        private String content;
        private String author;
    }

    @ToString
    @Builder
    @Getter
    @AllArgsConstructor
    public static class PatchCommentRequest {
        private Integer commentId;
        private String content;
        private String author;
    }

    @ToString
    @Builder
    @Getter
    @Setter
    @AllArgsConstructor
    public static class CommentResponse {
        private String userEmail;
        private Integer postId;
        private Integer commentId;
        private String content;
        private LocalDateTime createTime;
        private Boolean isDeleted;
        private String author;

        public static CommentResponse toResponse(Comment comment){
            return CommentResponse.builder()
                    .userEmail(comment.getUser().getEmail())
                    .postId(comment.getPost().getId())
                    .commentId(comment.getId())
                    .content(comment.getContent())
                    .createTime(comment.getCreateTime())
                    .isDeleted(comment.isDeleted())
                    .author(comment.getAuthor())
                    .build();
        }

        public static List<CommentResponse> toResponse(List<Comment> list){
            return list.stream().map(CommentResponse::toResponse).collect(Collectors.toList());
        }
    }
}
