package com.github.board.web.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String user_name;

    private String email;
    private String password;

    private LocalDateTime create_time= LocalDateTime.now();




    private boolean is_deleted= false;


}
