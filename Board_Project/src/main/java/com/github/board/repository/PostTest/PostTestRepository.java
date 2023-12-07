package com.github.board.repository.PostTest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostTestRepository extends JpaRepository<PostTest, Integer> {
    List<PostTest> findByAuthor(String author);
    }

