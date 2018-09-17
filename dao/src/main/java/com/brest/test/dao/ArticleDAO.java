package com.brest.test.dao;

import com.brest.test.Article;

import java.util.List;

/**
 * Article DAO interface
 */
public interface ArticleDAO {

    /**
     * Return all articles from database
     * @return List<Article>
     */
    List<Article> getAllArticles();

    Article getArticleById(Integer articleId);

    Article addArticle (Article article);

    void updateArticle (Article article);

    void deleteArticleById (Integer articleId);
}
