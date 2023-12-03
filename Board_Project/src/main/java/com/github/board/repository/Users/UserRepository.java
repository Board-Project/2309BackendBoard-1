package com.github.board.repository.Users;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {


   Optional<UserEntity> findByEmail(String email);



   Optional<UserEntity>findByEmailAndPassword(String email, String password);

}
