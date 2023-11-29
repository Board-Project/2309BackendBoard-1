package com.github.board.service;

import com.github.board.repository.Articles.ArticleEntity;
import com.github.board.repository.Articles.TestJpaRepository;
import com.github.board.service.exceptions.NotFoundException;
import com.github.board.service.mapper.ArticleMapper;
import com.github.board.web.dto.articles.Article;
import jakarta.persistence.Cacheable;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class TestService {

    private final TestJpaRepository testJpaRepository;


    public List<Article> findAllArticles(){
        List<ArticleEntity> articleEntities= testJpaRepository.findAll();
        if (articleEntities.isEmpty())throw new NotFoundException("아무 Articles 찾을 수 없음");
        return articleEntities.stream().map(ArticleMapper.INSTANCE::ArticleEntityToArticle).collect(Collectors.toList());

    }



}
