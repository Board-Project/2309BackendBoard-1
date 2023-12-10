package com.github.board.repository.Comment;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer> {

    List<Comment> findAllByPost_Id(Integer postId);
    List<Comment> findAllBy();
}
