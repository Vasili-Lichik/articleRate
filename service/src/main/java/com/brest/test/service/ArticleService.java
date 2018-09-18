package com.brest.test.service;

import com.brest.test.Article;
import com.brest.test.ArticleDto;

import java.util.List;

public interface ArticleService {
    List<Article> getAllArticles();
    Article getArticleById(Integer articleId);
    Article addArticle (Article article);
    void updateArticle (Article article);
    void deleteArticleById (Integer articleId);
    public  List<ArticleDto> getAllArticleDto();
}
