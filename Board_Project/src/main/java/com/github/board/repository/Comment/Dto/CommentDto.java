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
@NoArgsConstructor
public class CommentDto {

    private Integer post_id;

    private String content;

    private String author;

//    private LocalDateTime create_time;

}
