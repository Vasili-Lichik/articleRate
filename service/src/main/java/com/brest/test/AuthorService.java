package com.brest.test;

import java.util.List;

public interface AuthorService {
    List<Author> getAllAuthor ();
    Author getAuthorById (Integer id);
    Author addAuthor (Author author);
    void updateAuthor(Author author);
    void deleteAuthorById (Integer authorId);
}
