package com.github.board.web.dto.postTest;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PostTestDto {
    private Integer id;
    private String title;
    private String content;
    private String author;
    private LocalDateTime createTime = LocalDateTime.now();


}
