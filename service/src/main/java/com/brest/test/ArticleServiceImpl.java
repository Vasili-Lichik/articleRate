package com.brest.test;

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
}
