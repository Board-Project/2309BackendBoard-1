package com.github.board.web.controller;


import com.github.board.service.UserService;
import com.github.board.service.security.JwtProvider;
import com.github.board.web.dto.user.Response;
import com.github.board.web.dto.user.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name="유저인증",description = "회원가입, 로그인, 로그아웃 API 입니다.")
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api")
public class UserController {
        private final UserService userService;
        private final JwtProvider jwtProvider;
    @Operation(summary = "회원가입", description = "유저 회원가입을 진행합니다. user_name, email, password 기입")
    @PostMapping("/signup")
    public ResponseEntity<Response> signup(@RequestBody User user)
    {
        String signup = userService.saveUser(user);
        HttpHeaders headers = new HttpHeaders();
        Response signupResponse = new Response();
        signupResponse.setMessage(signup);

        return ResponseEntity.ok()
                .headers(headers)
                .body(signupResponse);
    }
    @Operation(summary = "로그인", description = "유저 로그인을 진행합니다. email, password 만 기입")
    @PostMapping("/login")
    public ResponseEntity<Response> userLogin(@RequestBody User user){
        Response signupResponse = new Response();

        String token = userService.userLogin(user);

        if(token != null) {
            HttpHeaders headers = new HttpHeaders();

            headers.setBearerAuth(token);
            signupResponse.setMessage("로그인 성공, JWT 생성이 완료되었습니다");
            return ResponseEntity.status(200).headers(headers).body(signupResponse);

        } else
            signupResponse.setMessage("가입되지 않은 정보입니다. 회원가입을 먼저 해주십시오.");

        return ResponseEntity.status(404).body(signupResponse);

    }
    @Operation(summary = "로그아웃", description = "유저 로그아웃을 진행합니다. 로그인할 때 발급받은 토큰을 기입해주세요")
    @PostMapping("/logout")
    public Response userLogout(@RequestHeader("Token") String token){
        String userLogout = userService.userLogout(token.substring(7));

        Response response = new Response();


        response.setMessage(userLogout);

        return response;
    }



}
