package com.github.board.web.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(allowableValues = "PuBao")
    private String user_name;
    @Schema( allowableValues = "PuBao12@naver.com")
    private String email;
    @Schema(allowableValues = "1234")
    private String password;
    @Schema(hidden = true)
    private LocalDateTime create_time= LocalDateTime.now();







}
