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
       // private Integer user_id;
        private String title;
        private String content;
        private String author;
       // private Integer like_cnt;
        //private Integer visitor_cnt;
        private Integer create_time;
        private LocalDateTime update_time;




        }


