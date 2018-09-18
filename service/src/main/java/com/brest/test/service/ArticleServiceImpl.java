package com.brest.test.service;

import com.brest.test.Article;
import com.brest.test.ArticleDto;
import com.brest.test.dao.ArticleDAO;

import java.util.List;

public class ArticleServiceImpl implements ArticleService{

    private ArticleDAO articleDAO;

    public ArticleServiceImpl(ArticleDAO articleDAO) {
        this.articleDAO = articleDAO;
    }

    public List<Article> getAllArticles() {
        return articleDAO.getAllArticles();
    }

    public Article getArticleById(Integer articleId) {
        return articleDAO.getArticleById(articleId);
    }

    public Article addArticle(Article article) {
        return articleDAO.addArticle(article);
    }

    public void updateArticle(Article article) {
        articleDAO.updateArticle(article);
    }

    public void deleteArticleById(Integer articleId) {
        articleDAO.deleteArticleById(articleId);
    }

    public  List<ArticleDto> getAllArticleDto(){
        return articleDAO.getAllArticleDto();
    }
}
