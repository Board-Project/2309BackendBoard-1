package com.github.board.web.controller;

import com.github.board.repository.PostTest.PostTest;
import com.github.board.service.PostTestService;
import com.github.board.service.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PostTestController {
    private final PostTestService postTestService;

    // 게시물 생성
    @PostMapping("/post-test")
    public ResponseEntity<String> createPostTest(@RequestBody PostTest postTest) {
        PostTest createPostTest = postTestService.createPostTest(postTest);
        if (createPostTest != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body("게시물이 생성되었습니다.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("게시물 생성에 실패했습니다.");
        }
    }

    // 모든 게시물 조회
    @GetMapping("/post-test")
    public List<PostTest> findPostTest() {
        return postTestService.getAllPostTest();
    }

    // 게시물 조회 id
    @GetMapping("/post-test/{id}")
    public Optional<PostTest> findPostTestById(@PathVariable Integer id) {
        return postTestService.getPostTestById(id);
    }

    // 게시물 수정
    @PutMapping("/post-test/{id}") // PathVariable URL 변수, RequestBody PUT 요청 JSON 형태 데이터 받을때 활용
    public ResponseEntity<PostTest> updatePostTest(@PathVariable Integer id, @RequestBody PostTest updatePostTest) {
        // try-catch 블록을 사용하는 이유 : NotFoundException 예외 처리
        try {
            PostTest postTest = postTestService.updatePostTest(id, updatePostTest);
            return ResponseEntity.ok(postTest);
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();

        }
    }

    // 게시물 삭제

    @DeleteMapping("/post-test/{id}")
    public ResponseEntity<?> deletePostTest(@PathVariable Integer id) {
        // <?>를 사용하는 이유는 응답을 동적으로 결정할 수 있기 떄문에 실패 시 예외 메시지 반환 가능
        try {
            postTestService.deletePostTest(id);
            return ResponseEntity.ok().build();
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    //추가: 이메일로 게시물 검색 API
    @GetMapping("/byemail-test/{author}")
    public List<PostTest> findPostTestByAuthor(@PathVariable String author){
        return postTestService.getPostTestByAuthor(author);
    }
}
