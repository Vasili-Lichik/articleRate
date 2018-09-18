package com.brest.test.dao;

import com.brest.test.Article;
import com.brest.test.ArticleDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ArticleDAOImpl implements ArticleDAO {
    /**
     * SQL request for get all articles
     */
    @Value("${article.select}")
    private String select;
    /**
     * SQL request for get article by ID
     */
    @Value("${article.selectById}")
    private String selectById;
    /**
     * SQL request for insert article
     */
    @Value("${article.insert}")
    private String insert;

    /**
     * SQL request for update article
     */
    @Value("${article.update}")
    private String updateSql;

    /**
     * SQL request for delete article
     */
    @Value("${article.delete}")
    private String deleteSql;

    @Value("${article.selectDto}")
    private String selectDto;

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
        SqlParameterSource namedParameters = new MapSqlParameterSource("articleId", articleId);
        Article article = namedParameterJdbcTemplate.queryForObject(selectById, namedParameters,
                BeanPropertyRowMapper.newInstance(Article.class));
        return article;
    }

    public Article addArticle(Article article) {
        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(article);
        KeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(insert, namedParameters, generatedKeyHolder);
        article.setArticleId(generatedKeyHolder.getKey().intValue());
        return article;
    }

    public void updateArticle(Article article) {
        SqlParameterSource namedParameter = new BeanPropertySqlParameterSource(article);
        namedParameterJdbcTemplate.update(updateSql,namedParameter);
    }

    public void deleteArticleById(Integer articleId) {
        namedParameterJdbcTemplate.getJdbcOperations().update(deleteSql, articleId);
    }

    public  List<ArticleDto> getAllArticleDto(){
        List<ArticleDto> articlesDto =
                namedParameterJdbcTemplate.getJdbcOperations().query(selectDto, new ArticlesDtoRowMapper());
        return articlesDto;
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

    private class ArticlesDtoRowMapper implements RowMapper<ArticleDto>{
        @Override
        public ArticleDto mapRow(ResultSet resultSet, int i) throws SQLException {
            ArticleDto articleDto = new ArticleDto();
            articleDto.setArticleId(resultSet.getInt("articleId"));
            articleDto.setArticleName(resultSet.getString("articleName"));
            articleDto.setArticleRate(resultSet.getInt("articleRate"));
            articleDto.setArticleAuthorName(resultSet.getString("articleAuthorName"));
            return articleDto;
        }
    }
}
