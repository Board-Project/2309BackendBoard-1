package com.github.board.web.dto.articles;

import lombok.*;

import java.time.LocalDateTime;

@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor


public class PostDTO {
        private Integer id;
        private Integer user_id;
        private String title;
        private String content;
        private Integer is_deleted;
        private String author;
        private LocalDateTime create_time = LocalDateTime.now();


        }

