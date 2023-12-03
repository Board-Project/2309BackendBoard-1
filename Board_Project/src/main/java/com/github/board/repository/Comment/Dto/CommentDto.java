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
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {
    @ToString
    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateCommentRequest {
        private Integer boardIndex;
        private String content;
        private String author;
    }

    @ToString
    @Builder
    @Getter
    @NoArgsConstructor
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
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CommentResponse {
        private String userEmail;
        private Integer boardIndex;
        private Integer commentId;
        private String content;
        private Integer like;
        private LocalDateTime createTime;
        private LocalDateTime updateTime;
        private Boolean isDeleted;
        private String author;

        public static CommentResponse toResponse(Comment comment){
            return CommentResponse.builder()
                    .userEmail(comment.getUser().getEmail())
                    .boardIndex(comment.getPost().getId())
                    .commentId(comment.getId())
                    .content(comment.getContent())
                    .like(comment.getLike())
                    .createTime(comment.getCreateTime())
                    .updateTime(comment.getUpdateTime())
                    .isDeleted(comment.isDeleted())
                    .author(comment.getAuthor())
                    .build();
        }

        public static List<CommentResponse> toResponse(List<Comment> list){
            return list.stream().map(CommentResponse::toResponse).collect(Collectors.toList());
        }
    }

}
