package com.github.board.repository.Comment.Service;

import com.github.board.entity.Post;
import com.github.board.repository.Articles.PostRepository;
import com.github.board.repository.Comment.Dto.CommentDto;
import com.github.board.repository.Comment.Entity.Comment;
import com.github.board.repository.Comment.Repository.CommentRepository;
import com.github.board.service.exceptions.NotFoundException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;


    public List<Comment> findByPostId(Integer postId) {
        return commentRepository.findAllByPost_Id(postId);
    }

    public List<Comment> findAll() {
        return commentRepository.findAllBy();
    }

    public void saveComment(CommentDto commentDto) {
        Post post = postRepository.findById(commentDto.getPost_id())
                .orElseThrow(() -> new EntityNotFoundException("해당 ID의 게시물을 찾을 수 없습니다."));

        Comment comment = Comment.builder()
                .post(post)
                .author(commentDto.getAuthor())
                .content(commentDto.getContent())
                .createTime(LocalDateTime.now())
                .build();

        commentRepository.save(comment);
    }

    public Comment updateComment( Comment updatedComment, Integer id) {


        Optional<Comment> existingComment = commentRepository.findById(id);

        if (existingComment.isPresent()) {
            Comment comment = existingComment.get();
            comment.setContent(updatedComment.getContent());
            return commentRepository.save(comment);
        } else {
            throw new NotFoundException("댓글을 찾을 수 없습니다.");
        }
    }

    public void deleteComment(Integer id) {
        Optional<Comment> existingComment = commentRepository.findById(id);

        if (existingComment.isPresent()) {
            commentRepository.deleteById(id);

        } else {
            throw new NotFoundException("댓글을 찾을 수 없습니다.");
        }
    }
}
