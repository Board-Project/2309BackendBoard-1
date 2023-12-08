package com.github.board.web.controller;

import com.github.board.web.dto.Comment.CommentDto;
import com.github.board.repository.Comment.Comment;
import com.github.board.service.CommentService;
import com.github.board.service.exceptions.NotFoundException;
import com.github.board.service.security.JwtProvider;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Tag(name = "댓글", description = "댓글 관련 api 입니다.")
public class CommentController {

    private final CommentService commentService;
    private final JwtProvider jwtService;


    @GetMapping("/comments")
    @Operation(summary = "댓글 전체 조회",description = "전체 댓글을 조회 합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "전체 댓글 조회 성공"),
            @ApiResponse(responseCode = "400", description = "전체 댓글 조회 실패")
    })
    public List<Comment> findAll() {

        return commentService.findAll();
    }

    @GetMapping("/comments/{post_id}")
    @Operation(summary = "post_id로 댓글 조회",description = "id로 댓글을 조회 합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "id로 댓글을 조회 성공"),
            @ApiResponse(responseCode = "400", description = "id로 댓글을 조회 실패")
    })
    public List<Comment> findByPostId(@PathVariable Integer post_id) {

        return commentService.findByPostId(post_id);
    }

    @PostMapping("/comments")
    @Operation(summary = "댓글 추가",description = "post_id와 content만 추가 해주세요!! 댓글을 추가 합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "댓글 추가 성공"),
            @ApiResponse(responseCode = "400", description = "댓글 추가 실패"),
    })
    public ResponseEntity<?> createComment(@RequestBody CommentDto commentDto, @RequestHeader("Token") String token) {
        String author = jwtService.extractUserId(token);
        commentDto.setAuthor(author);
        commentService.saveComment(commentDto);
        return ResponseEntity.ok("댓글이 성공적으로 작성되었습니다.");
    }

    @PutMapping("/comments/{id}")
    @Operation(summary = "댓글 수정",description = "댓글을 수정 합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "댓글 수정 성공"),
            @ApiResponse(responseCode = "400", description = "댓글 수정 실패")
    })
    public ResponseEntity<?> updateComment(@PathVariable Integer id, @RequestBody Comment updatedComment,
                                           @RequestHeader("Token") String token) {
        String author = jwtService.extractUserId(token);

        try {
            Comment comment= commentService.updateComment(updatedComment,id);
            return ResponseEntity.ok(comment);
        }catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }




    }
    @DeleteMapping("/comments/{id}")
    @Operation(summary = "댓글 삭제", description = "댓글을 삭제 합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "댓글 삭제 성공"),
            @ApiResponse(responseCode = "400", description = "댓글 삭제 실패")
    })
    @Parameter(name = "author",hidden = true)
    public ResponseEntity<?> deleteComment(@PathVariable Integer id,  @RequestHeader("Token") String token) {
        try {
            commentService.deleteComment(id);
            return ResponseEntity.ok("댓글 삭제 완료!");


        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
