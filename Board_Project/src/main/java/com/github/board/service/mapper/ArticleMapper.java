package com.github.board.service.mapper;

import com.github.board.repository.Articles.ArticleEntity;
import com.github.board.web.dto.articles.Article;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;

@Mapper
public interface ArticleMapper {

    ArticleMapper INSTANCE = Mappers.getMapper(ArticleMapper.class);


    Article ArticleEntityToArticle (ArticleEntity articleEntity);

}
