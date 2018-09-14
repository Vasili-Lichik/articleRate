package com.brest.test;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AuthorServiceImpl implements AuthorService {

    private AuthorDAO authorDAO;

    public AuthorServiceImpl(AuthorDAO authorDAO) {
        this.authorDAO = authorDAO;
    }

    public List<Author> getAllAuthor() {
        return authorDAO.getAllAuthor();
    }

    public Author getAuthorById(Integer id) {
        return  authorDAO.getAuthorById(id);
    }

    public Author addAuthor(Author author) {
        return authorDAO.addAuthor(author);
    }

    public void updateAuthor(Author author) {
        authorDAO.updateAuthor(author);
    }

    public void deleteAuthorById(Integer authorId) {
        authorDAO.deleteAuthorById(authorId);
    }
}
