package com.github.board.web.dto.articles;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor


public class PostDTO {
//        @Schema(hidden = true)

        private Integer id;
        private String title;
        private String content;
        private String author;
        private LocalDateTime create_time = LocalDateTime.now();


        }

