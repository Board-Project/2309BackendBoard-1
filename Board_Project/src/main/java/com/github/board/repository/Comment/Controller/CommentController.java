package com.github.board.repository.Comment.Controller;

import com.github.board.repository.Comment.Dto.CommentDto;
import com.github.board.repository.Comment.Entity.Comment;
import com.github.board.repository.Comment.Service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")

public class CommentController {

    private final CommentService commentService;
//    private final JwtService jwtService;

    @GetMapping("/comments")
    public List<CommentDto.CommentResponse> findAll() {
        List<Comment> comments = commentService.findAll();
        return CommentDto.CommentResponse.toResponse(comments);
    }

    @GetMapping("/comments/{post_id}")
    public List<CommentDto.CommentResponse> findByPostId(@PathVariable Integer post_id) {
        List<Comment> comments = commentService.findByPostId(post_id);
        return CommentDto.CommentResponse.toResponse(comments);
    }

    @PostMapping("/comments")
    public ResponseEntity<?> createComment(@RequestBody CommentDto.CreateCommentRequest commentDto, @RequestHeader("Token") String token) {
        String author = jwtService.extractUserId(token);
        commentDto.setAuthor(author);
        commentService.saveComment(commentDto);
        return ResponseEntity.ok("댓글이 성공적으로 작성되었습니다.");
    }

    @PutMapping("/comments/{id}")
    public ResponseEntity<?> updateComment(@PathVariable Integer id, @RequestBody CommentDto.PatchCommentRequest commentDto, @RequestHeader("Token") String token) {
        commentService.updateComment(commentDto, id);
        return ResponseEntity.ok("댓글이 성공적으로 수정되었습니다.");
    }

    @DeleteMapping("/comments/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable Integer id) {
        commentService.deleteComment(id);
        return ResponseEntity.ok("댓글이 성공적으로 삭제되었습니다.");
    }
}
