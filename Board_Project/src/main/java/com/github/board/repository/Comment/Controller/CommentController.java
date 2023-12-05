package com.github.board.repository.Comment.Controller;

import com.github.board.repository.Comment.Dto.CommentDto;
import com.github.board.repository.Comment.Entity.Comment;
import com.github.board.repository.Comment.Service.CommentService;
import com.github.board.service.exceptions.NotFoundException;
import com.github.board.service.security.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")

public class CommentController {

    private final CommentService commentService;
    private final JwtProvider jwtService;

    @GetMapping("/comments")
    public List<Comment> findAll() {

        return commentService.findAll();
    }

    @GetMapping("/comments/{post_id}")
    public List<Comment> findByPostId(@PathVariable Integer post_id) {

        return commentService.findByPostId(post_id);
    }

    @PostMapping("/comments")
    public ResponseEntity<?> createComment(@RequestBody CommentDto commentDto, @RequestHeader("Token") String token) {
        String author = jwtService.extractUserId(token);
        commentDto.setAuthor(author);
        commentService.saveComment(commentDto);
        return ResponseEntity.ok("댓글이 성공적으로 작성되었습니다.");
    }

    @PutMapping("/comments/{id}")
    public ResponseEntity<?> updateComment(@PathVariable Integer id, @RequestBody Comment updatedComment, @RequestHeader("Token") String token) {
        String author = jwtService.extractUserId(token);

        try {
            Comment comment= commentService.updateComment(updatedComment,id);
            return ResponseEntity.ok(comment);
        }catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }




    }
    @DeleteMapping("/comments/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable Integer id,  @RequestHeader("Token") String token) {
        try {
            commentService.deleteComment(id);
            return ResponseEntity.ok("댓글 삭제 완료!");


        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
