package com.github.board.service.mapper;

import com.github.board.repository.Users.UserEntity;
import com.github.board.web.dto.user.User;
import lombok.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper

public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);


    UserEntity UserToUserEntity(User user);

    User userEntityToUser(UserEntity userEntity);

}
