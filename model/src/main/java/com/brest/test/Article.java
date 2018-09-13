package com.brest.test;

public class Article {

    /**
     * articleId.
     */
    private Integer articleId;

    /**
     * articleName.
     */
    private String articleName;

    /**
     * articleRate.
     */
    private Integer articleRate;

    /**
     * authorId
     */

    private Integer articleAuthorId;

    /**
     * constructor without param.
     */
    public Article() {
    }

    /**
     * constructor with param.
     * @param articleName
     * @param articleRate
     * @param articleAuthorId
     */
    public Article(String articleName, Integer articleRate, Integer articleAuthorId) {
        this.articleName = articleName;
        this.articleRate = articleRate;
        this.articleAuthorId = articleAuthorId;
    }

    /**
     * getter for articleId.
     * @return articleId
     */
    public Integer getArticleId() {
        return articleId;
    }

    /**
     * setter for articleId.
     * @param articleId
     */
    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    /**
     * getter for articleName.
     * @return articleName
     */
    public String getArticleName() {
        return articleName;
    }

    /**
     * setter for articleName.
     * @param articleName
     */
    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    /**
     * getter for articleRate.
     * @return articleRate
     */
    public Integer getArticleRate() {
        return articleRate;
    }

    /**
     * setter for articleRate.
     * @param articleRate
     */
    public void setArticleRate(Integer articleRate) {
        this.articleRate = articleRate;
    }

    /**
     * getter for ArticleAuthorId
     * @return articleAuthorId
     */
    public Integer getArticleAuthorId() {
        return articleAuthorId;
    }

    /**
     * setter for articleRate.
     * @param articleAuthorId
     */
    public void setArticleAuthorId(Integer articleAuthorId) {
        this.articleAuthorId = articleAuthorId;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId=" + articleId +
                ", articleName='" + articleName + '\'' +
                ", articleRate=" + articleRate +
                ", articleAuthorId=" + articleAuthorId +
                '}';
    }
}
