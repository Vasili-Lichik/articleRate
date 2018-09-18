package com.brest.test.dao;

import com.brest.test.Author;
import com.brest.test.AuthorDto;
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
    /**
     * SQL request for get all authors
     */
    @Value("${author.select}")
    private String select;
    /**
     * SQL request for insert author
     */
    @Value("${author.insert}")
    private String insert;
    /**
     * SQL request for select author by ID
     */
    @Value("${author.selectById}")
    private String selectById;
    /**
     * SQL request for update author
     */
    @Value("${author.update}")
    private String updateSql;
    /**
     * SQL request for delete author
     */
    @Value("${author.delete}")
    private String deleteSql;

    @Value("${author.selectDto}")
    private String selectDto;


    @Override
    public final List<Author> getAllAuthor() {
        List<Author> list =
                namedParameterJdbcTemplate.getJdbcOperations().query(select, new AuthorRowMapper());
        return list;
    }

    @Override
    public final Author getAuthorById(Integer authorId) {
        SqlParameterSource namedParameters = new MapSqlParameterSource("authorId", authorId);
        Author author = namedParameterJdbcTemplate.queryForObject(selectById, namedParameters,
                BeanPropertyRowMapper.newInstance(Author.class));
        return author;
    }

    @Override
    public final Author addAuthor(Author author) {
        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(author);
        KeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(insert, namedParameters, generatedKeyHolder);
        author.setAuthorId(generatedKeyHolder.getKey().intValue());
        return author;
    }

    @Override
    public final void updateAuthor(Author author) {
        SqlParameterSource namedParameter = new BeanPropertySqlParameterSource(author);
        namedParameterJdbcTemplate.update(updateSql, namedParameter);
    }

    @Override
    public final void deleteAuthorById(Integer authorId) {
        namedParameterJdbcTemplate.getJdbcOperations().update(deleteSql, authorId);
    }


    @Override
    public List<AuthorDto> getAllAuthorDto() {
        List<AuthorDto> list =
                namedParameterJdbcTemplate.getJdbcOperations().query(selectDto, new AuthorDtoRowMapper());
        return list;
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

    private class AuthorDtoRowMapper implements RowMapper<AuthorDto> {
        @Override
        public AuthorDto mapRow(ResultSet resultSet, int i) throws SQLException {
            AuthorDto authorDto = new AuthorDto();
            authorDto.setAuthorId(resultSet.getInt("authorId"));
            authorDto.setAuthorName(resultSet.getString("authorName"));
            authorDto.setAuthorEmail(resultSet.getString("authorEmail"));
            authorDto.setAvgArticleRate(resultSet.getFloat("avgArticleRate"));
            return authorDto;
        }
    }

}
