package com.brest.test;

public class AuthorDto {
    /**
     * authorId.
     */
    private Integer authorId;

    /**
     * authorName.
     */
    private String authorName;

    /**
     * authorEmail.
     */
    private String authorEmail;

    private float AvgArticleRate;

    public AuthorDto() {
    }

    public AuthorDto(Integer authorId, String authorName, String authorEmail, float avgArticleRate) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.authorEmail = authorEmail;
        AvgArticleRate = avgArticleRate;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }

    public float getAvgArticleRate() {
        return AvgArticleRate;
    }

    public void setAvgArticleRate(float avgArticleRate) {
        AvgArticleRate = avgArticleRate;
    }

    @Override
    public String toString() {
        return "AuthorDto{" +
                "authorId=" + authorId +
                ", authorName='" + authorName + '\'' +
                ", authorEmail='" + authorEmail + '\'' +
                ", AvgArticleRate=" + AvgArticleRate +
                '}';
    }
}
