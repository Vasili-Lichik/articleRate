package com.brest.test;

import com.brest.test.dao.AuthorDAO;
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

@ContextConfiguration(locations = {
        "classpath:test-db-spring.xml",
        "classpath:test-dao.xml",
        "classpath:dao.xml"})
@Rollback
@Transactional
public class AuthorDAOImplTest {
    @Autowired
    AuthorDAO authorDAO;

    @Test
    public void getAllAuthor() {
        List<Author> list = authorDAO.getAllAuthor();
        Assert.assertFalse(list.isEmpty());
    }

    @Test
    public void addAuthor(){
        List<Author> list = authorDAO.getAllAuthor();
        int sizeBefore = list.size();
        Author author = new Author("Vasili","vlichik@brw.brest.by");
        Author newAuthor = authorDAO.addAuthor(author);
        Assert.assertNotNull(newAuthor.getAuthorId());
        Assert.assertTrue(newAuthor.getAuthorName().equals(author.getAuthorName()));
        Assert.assertTrue(newAuthor.getAuthorEmail().equals(author.getAuthorEmail()));
        Assert.assertTrue((sizeBefore + 1) == authorDAO.getAllAuthor().size());
    }

    @Test
    public void getAuthorById() {
        Author author = new Author("Vasili","vlichik@brw.brest.by");
        author = authorDAO.addAuthor(author);
        Author newAuthor  = authorDAO.getAuthorById(author.getAuthorId());
        Assert.assertNotNull(newAuthor);
        Assert.assertTrue(author.getAuthorId().equals(newAuthor.getAuthorId()));
        Assert.assertTrue(author.getAuthorName().equals(newAuthor.getAuthorName()));
        Assert.assertTrue(author.getAuthorEmail().equals(newAuthor.getAuthorEmail()));
    }

    @Test
    public void updateAuthor (){
        Author author = new Author("Vasili","vlichik@brw.brest.by");
        Author newAuthor = authorDAO.addAuthor(author);
        newAuthor.setAuthorName("Petya");
        newAuthor.setAuthorEmail("lvasili87@gmail.com");
        authorDAO.updateAuthor(newAuthor);
        Author updatedAuthor = authorDAO.getAuthorById(newAuthor.getAuthorId());
        Assert.assertTrue (updatedAuthor.getAuthorId().equals(newAuthor.getAuthorId()));
        Assert.assertTrue (updatedAuthor.getAuthorName().equals(newAuthor.getAuthorName()));
        Assert.assertTrue(updatedAuthor.getAuthorEmail().equals(newAuthor.getAuthorEmail()));
    }

    @Test
    public void deleteAuthorById (){
        Author author = new Author("Vasili","vlichik@brw.brest.by");
        author = authorDAO.addAuthor(author);
        List<Author> list = authorDAO.getAllAuthor();
        int sizeBefore = list.size();
        authorDAO.deleteAuthorById(author.getAuthorId());
        Assert.assertTrue((sizeBefore - 1) == authorDAO.getAllAuthor().size());
    }
}
