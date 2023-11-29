package com.github.board.web.controller;

import com.github.board.service.TestService;
import com.github.board.web.dto.articles.Article;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class TestController {


    private final TestService testService;


    @ApiOperation("모든 게시글 을 검색")
    @GetMapping("/articles")
    public List<Article> findAllArticles(){
        List<Article> articles=testService.findAllArticles();
        return articles;
    }

}
