package com.github.board.repository.Articles;

import com.github.board.entity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
//     CRUD (Create, Read, Update, Delete) 작업을 수행 가능　

    // 특정 ID로 게시물 조회 - Optional : ID에 해당하는 게시물이 존재하지 않을 경우 예외를 방지할 수 있음
    Optional<Post> findById(int id);
    List<Post> findByAuthor(String Author); //특정 email(author) 검색
}