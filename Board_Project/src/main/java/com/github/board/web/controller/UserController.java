package com.github.board.web.controller;


import com.github.board.service.UserService;
import com.github.board.service.security.JwtProvider;
import com.github.board.web.dto.user.Response;
import com.github.board.web.dto.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api")
public class UserController {
        private final UserService userService;
        private final JwtProvider jwtProvider;
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

    @PostMapping("/logout")
    public Response userLogout(@RequestHeader("Token") String token){
        String userLogout = userService.userLogout(token.substring(7));

        Response response = new Response();


        response.setMessage(userLogout);

        return response;
    }



}
