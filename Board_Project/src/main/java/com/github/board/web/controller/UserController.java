package com.github.board.web.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")


public class UserController {

//    private final UserService userService;
//    @PostMapping("/signup")
//    public ResponseEntity<?> signUp(@RequestBody SignupReq signupReq){
//        userService.signup(signupReq);
//        return ResponseEntity.ok(new SignupRes("회원가입이 완료되었습니다."));
//    }
//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestBody LoginReq loginReq){
//        return userService.login(loginReq);
//    }
//
//    @PostMapping("/logout")
//    public ResponseEntity<Map<String,String>> logout(@RequestBody LogoutReq logoutReq){
//        return userService.logout(logoutReq);
//    }



}
