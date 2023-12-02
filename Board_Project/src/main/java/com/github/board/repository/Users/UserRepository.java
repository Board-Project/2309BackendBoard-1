package com.github.board.repository.Users;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {


    boolean existsByEmail(String email);

    UserEntity findByEmail(String email);
}
