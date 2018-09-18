package com.brest.test;

public class ArticleDto {
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
     * authorName for ArticleDto.
     */
    private String articleAuthorName;

    public ArticleDto() {}

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public Integer getArticleRate() {
        return articleRate;
    }

    public void setArticleRate(Integer articleRate) {
        this.articleRate = articleRate;
    }

    public String getArticleAuthorName() {
        return articleAuthorName;
    }

    public void setArticleAuthorName(String articleAuthorName) {
        this.articleAuthorName = articleAuthorName;
    }

    @Override
    public String toString() {
        return "ArticleDto{" +
                "articleId=" + articleId +
                ", articleName='" + articleName + '\'' +
                ", articleRate=" + articleRate +
                ", articleAuthorName='" + articleAuthorName + '\'' +
                '}';
    }
}
