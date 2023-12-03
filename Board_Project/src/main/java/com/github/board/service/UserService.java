package com.github.board.service;

import com.github.board.repository.Users.UserEntity;
import com.github.board.repository.Users.UserRepository;
import com.github.board.service.mapper.UserMapper;
import com.github.board.service.security.JwtProvider;

import com.github.board.service.security.PsEncoder;
import com.github.board.web.dto.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;
    private final PsEncoder psEncoder;

    public String saveUser(User user) {
        Optional<UserEntity> byEmail = userRepository.findByEmail(user.getEmail());

        if (byEmail.isPresent()) {

            return "이미 가입된 정보입니다, 같은 email이 등록되어 있습니다.";
        } else {

            passwordEncoding(user);

            UserEntity userEntity = UserMapper.INSTANCE.UserToUserEntity(user);



            userRepository.save(userEntity);
            return "회원가입이 완료되었습니다";

        }
    }







    public String userLogout(String token) {

        return getString(token);
    }


    public String userLogin(User user) {
        Optional<UserEntity> byEmail =userRepository.findByEmail(user.getEmail());

        if(byEmail.isPresent()) {
            String password = byEmail.get().getPassword();
            boolean matches = psEncoder.passwordEncoder().matches(user.getPassword(), password);
            if (matches){

                return jwtProvider.encode(user);

            }  else return null;
        } else return null;
    }



    private String getString(String token) {
        if (jwtProvider.isTokenExpired(token)) {
            return "만료된 토큰입니다";
        }
        if (!jwtProvider.isPresent(token)) {
            return "가입되지 않은 정보입니다. 토큰을 다시 한 번 확인해주세요";
        } else return "로그아웃 하였습니다.";
    }

    private User passwordEncoding(User user) {
        String userEncodedPWD = psEncoder.passwordEncoder().encode(user.getPassword());
        user.setPassword(userEncodedPWD);
        return user;
    }
}
