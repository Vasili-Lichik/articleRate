package com.brest.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@Rollback
@Transactional

@ContextConfiguration(locations = {
        "classpath:test-db-spring.xml",
        "classpath:test-dao.xml",
        "classpath:dao.xml"})



public class ArticleDAOImplTest {
    @Autowired
    ArticleDAO articleDAO;

    @Test
    public void getAllArticles() {
        List<Article> list = articleDAO.getAllArticles();
        Assert.assertFalse(list.isEmpty());
    }

    @Test
    public void addArticle() {
        List<Article> list = articleDAO.getAllArticles();
        int sizeBefore = list.size();
        Article article = new Article("The story",8,2);
        Article newArticle = articleDAO.addArticle(article);
        Assert.assertNotNull(newArticle.getArticleId());
        Assert.assertTrue(newArticle.getArticleName().equals(article.getArticleName()));
        Assert.assertTrue(newArticle.getArticleRate().equals(article.getArticleRate()));
        Assert.assertTrue((sizeBefore + 1) == articleDAO.getAllArticles().size());

    }

    @Test
    public void getArticleById(){
        Article article = new Article("The story",8,2);
        article = articleDAO.addArticle(article);
        Article newArticle  = articleDAO.getArticleById(article.getArticleId());
        Assert.assertNotNull(newArticle);
        Assert.assertTrue(article.getArticleId().equals(newArticle.getArticleId()));
        Assert.assertTrue(article.getArticleName().equals(newArticle.getArticleName()));
        Assert.assertTrue(article.getArticleRate().equals(newArticle.getArticleRate()));
        Assert.assertTrue(article.getArticleAuthorId().equals(newArticle.getArticleAuthorId()));
    }

    @Test
    public void updateArticle() {
        Article article = new Article("The story",8,2);
        Article newArticle = articleDAO.addArticle(article);
        Assert.assertNotNull(newArticle);
        newArticle.setArticleName("New story");
        newArticle.setArticleRate(6);
        newArticle.setArticleAuthorId(1);
        articleDAO.updateArticle(newArticle);
        Article updatedArticle = articleDAO.getArticleById(newArticle.getArticleId());
        Assert.assertNotNull(updatedArticle);
//        Assert.assertTrue(updatedArticle.getArticleId().equals(newArticle.getArticleRate()));
//        Assert.assertTrue(updatedArticle.getArticleName().equals(newArticle.getArticleName()));
        Assert.assertTrue(updatedArticle.getArticleRate().equals(newArticle.getArticleRate()));
        Assert.assertTrue(updatedArticle.getArticleAuthorId().equals(newArticle.getArticleAuthorId()));
    }

    @Test
    public void deleteArticleById() {
        Article article = new Article("The story",8,2);
        article = articleDAO.addArticle(article);
        int sizeBefore = articleDAO.getAllArticles().size();
        articleDAO.deleteArticleById(article.getArticleId());
        int sizeAfter = articleDAO.getAllArticles().size();
        Assert.assertTrue(sizeBefore==sizeAfter+1);
    }
}
