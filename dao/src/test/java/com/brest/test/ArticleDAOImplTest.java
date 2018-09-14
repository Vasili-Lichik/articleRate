package com.brest.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)

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
}
