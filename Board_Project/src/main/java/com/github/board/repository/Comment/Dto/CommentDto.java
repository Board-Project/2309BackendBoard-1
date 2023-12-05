package com.github.board.repository.Comment.Dto;

import lombok.*;

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
