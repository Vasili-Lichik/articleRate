package com.brest.test;

public class Author {

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

    /**
     * constructor without param.
     */
    public Author() {}

    /**
     * constructor with param.
     * @param authorName
     * @param authorEmail
     */
    public Author(String authorName, String authorEmail) {
        this.authorName = authorName;
        this.authorEmail = authorEmail;
    }

    /**
     *
     * @return authorId.
     */
    public Integer getAuthorId() {
        return authorId;
    }

    /**
     *
     * @param authorId .
     */
    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    /**
     *
     * @return authorName
     */
    public String getAuthorName() {
        return authorName;
    }

    /**
     * setter for authorName
     * @param authorName
     */
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    /**
     *
     * @return authorEmail
     */
    public String getAuthorEmail() {
        return authorEmail;
    }

    /**
     * setter for authorEmail
     * @param authorEmail
     */
    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", authorName='" + authorName + '\'' +
                ", email='" + authorEmail + '\'' +
                '}';
    }
}
