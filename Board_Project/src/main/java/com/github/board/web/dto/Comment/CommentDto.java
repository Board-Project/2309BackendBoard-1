package com.github.board.web.dto.Comment;

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



}
