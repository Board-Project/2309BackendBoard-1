package com.github.board.repository.Posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    Optional<Post> findById(Integer id);
    List<Post> findByAuthor(String Author);
}