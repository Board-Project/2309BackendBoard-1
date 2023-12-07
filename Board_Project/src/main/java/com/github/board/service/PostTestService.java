package com.github.board.service;

import com.github.board.repository.PostTest.PostTest;
import com.github.board.repository.PostTest.PostTestRepository;
import com.github.board.service.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostTestService {
    private final PostTestRepository postTestRepository;
    // 게시글 생성
    public PostTest createPostTest(PostTest postTest){
        return postTestRepository.save(postTest);
    }
    // 모든 게시물 조회

    public List<PostTest> getAllPostTest(){
        return postTestRepository.findAll();
    }
    // 게시물 조회 id
    public Optional<PostTest> getPostTestById(Integer id){ // 물어보기 id를 조회하는데 Optional을 사용하는 이유
        return postTestRepository.findById(id); // 물어보기 레퍼지토리에 추가해서 해야되는지
    }
    // 게시물 수정
    public PostTest updatePostTest(Integer id, PostTest updatedPostTest){
        Optional<PostTest> existingPostTest = postTestRepository.findById(id);
        if (existingPostTest.isPresent()) {
            PostTest postTest = existingPostTest.get();
            postTest.setTitle(updatedPostTest.getTitle());
            postTest.setContent(updatedPostTest.getContent());
            return postTestRepository.save(postTest);
        }
        else {
            throw new NotFoundException("게시물을 찾을 수 없습니다.");
        }
    }

    // 게시물 삭제
    public void deletePostTest(Integer id) {
        Optional<PostTest> existingPostTest = postTestRepository.findById(id);
        if (existingPostTest.isPresent()) {
            postTestRepository.deleteById(id);
        } else {
            throw new NotFoundException("게시물을 찾을 수 없습니다.");
        }
    }

    // 게시물 이메일로 조회
    public List<PostTest> getPostTestByAuthor(String author){
        return postTestRepository.findByAuthor(author);
    }
}
