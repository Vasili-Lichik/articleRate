package com.brest.test.service;

import com.brest.test.Author;
import com.brest.test.AuthorDto;

import java.util.List;

public interface AuthorService {
    List<Author> getAllAuthor ();
    Author getAuthorById (Integer id);
    Author addAuthor (Author author);
    void updateAuthor(Author author);
    void deleteAuthorById (Integer authorId);
    List<AuthorDto> getAuthorDto();
}
