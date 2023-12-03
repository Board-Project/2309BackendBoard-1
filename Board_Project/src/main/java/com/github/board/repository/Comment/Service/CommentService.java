package com.github.board.repository.Comment.Service;

import com.github.board.repository.Comment.Dto.CommentDto;
import com.github.board.repository.Comment.Entity.Comment;
import com.github.board.repository.Comment.Repository.CommentRepository;
import com.github.board.service.exceptions.NotFoundException;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.Optional;

public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> findByPostId(Integer postId) {
        return commentRepository.findAllByPost_Id(postId);
    }

    public List<Comment> findAll() {
        return commentRepository.findAllBy();
    }

    public void saveComment(CommentDto.CreateCommentRequest commentDto) {
        Post post = postRepository.findById(commentDto.getBoardIndex())
                .orElseThrow(() -> new EntityNotFoundException("해당 ID의 게시물을 찾을 수 없습니다."));

        Comment comment = Comment.builder()
                .post(post)
                .author(commentDto.getAuthor())
                .content(commentDto.getContent())
                .build();

        commentRepository.save(comment);
    }

    public Comment updateComment(CommentDto.PatchCommentRequest commentDto, Integer id) {
        Optional<Comment> existingComment = commentRepository.findById(id);

        if (existingComment.isPresent()) {
            Comment comment = existingComment.get();
            comment.setContent(commentDto.getContent());
            return commentRepository.save(comment);
        } else {
            throw new NotFoundException("댓글을 찾을 수 없습니다.");
        }
    }

    public void deleteComment(Integer id) {
        Optional<Comment> existingComment = commentRepository.findById(id);

        if (existingComment.isPresent()) {
            Comment comment = existingComment.get();
            commentRepository.delete(comment);
        } else {
            throw new NotFoundException("댓글을 찾을 수 없습니다.");
        }
    }
}
