package com.brest.test.dao;

import com.brest.test.Author;

import java.util.List;

/**
 * Author DAO interface
 */

public interface AuthorDAO  {
    List<Author> getAllAuthor ();
    Author getAuthorById (Integer authorId);
    Author addAuthor (Author author);
    void updateAuthor(Author author);
    void deleteAuthorById (Integer authorId);
}
