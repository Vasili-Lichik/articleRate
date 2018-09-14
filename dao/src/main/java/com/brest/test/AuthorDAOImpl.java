package com.brest.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AuthorDAOImpl implements AuthorDAO {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public AuthorDAOImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Value("${author.select}")
    private String select;

    @Value("${author.insert}")
    private String insert;

    @Value("${author.selectById}")
    private String selectById;

    @Value("${author.update}")
    private String updateSql;

    @Value("${author.delete}")
    private String deleteSql;



    @Override
    public List<Author> getAllAuthor() {
        List<Author> list =
                namedParameterJdbcTemplate.getJdbcOperations().query(select, new AuthorRowMapper());
        return list;
    }

    @Override
    public Author getAuthorById(Integer authorId) {
        SqlParameterSource namedParameters = new MapSqlParameterSource("authorId", authorId);
        Author author = namedParameterJdbcTemplate.queryForObject(selectById, namedParameters,
                BeanPropertyRowMapper.newInstance(Author.class));
        return author;
    }

    @Override
    public Author addAuthor(Author author) {
        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(author);
        KeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(insert, namedParameters, generatedKeyHolder);
        author.setAuthorId(generatedKeyHolder.getKey().intValue());
        return author;
    }

    @Override
    public void updateAuthor(Author author) {
        SqlParameterSource namedParameter = new BeanPropertySqlParameterSource(author);
        namedParameterJdbcTemplate.update(updateSql, namedParameter);
    }

    @Override
    public void deleteAuthorById(Integer authorId) {
        namedParameterJdbcTemplate.getJdbcOperations().update(deleteSql, authorId);
    }

    private class AuthorRowMapper implements RowMapper<Author> {
        @Override
        public Author mapRow(ResultSet resultSet, int i) throws SQLException {
            Author author = new Author();
            author.setAuthorId(resultSet.getInt("authorId"));
            author.setAuthorName(resultSet.getString("authorName"));
            author.setAuthorEmail(resultSet.getString("authorEmail"));
            return author;
        }
    }


}
