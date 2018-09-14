package com.brest.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ArticleDAOImpl implements ArticleDAO {
    /**
     * SQL request for get all articles
     */
    @Value("${article.select}")
    private String select;


    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public ArticleDAOImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<Article> getAllArticles() {
        List<Article> articles =
                namedParameterJdbcTemplate.getJdbcOperations().query(select, new ArticlesRowMapper());
        return articles;
    }

    public Article getArticleById(Integer articleId) {
        return null;
    }

    public Article addArticle(Article article) {
        return null;
    }

    public void updateArticle(Article article) {

    }

    public void deleteArticleById(Integer articleId) {

    }

    private class ArticlesRowMapper implements RowMapper<Article> {
        @Override
        public Article mapRow(ResultSet resultSet, int i) throws SQLException {
            Article article = new Article();
            article.setArticleId(resultSet.getInt("articleId"));
            article.setArticleName(resultSet.getString("articleName"));
            article.setArticleRate(resultSet.getInt("articleRate"));
            article.setArticleId(resultSet.getInt("articleAuthorId"));
            return article;
        }
    }
}
