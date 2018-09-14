DROP TABLE IF EXISTS author;
CREATE TABLE author (
  authorId INT NOT NULL AUTO_INCREMENT,
  authorName VARCHAR(255) NOT NULL,
  authorEmail VARCHAR(255) NULL,
  PRIMARY KEY (authorId)
);
DROP TABLE IF EXISTS article;
CREATE TABLE article (
  articleId INT NOT NULL AUTO_INCREMENT,
  articleName VARCHAR(255) NOT NULL,
  articleRate INT NOT NULL,
  articleAuthorId INT,
  PRIMARY KEY (articleId),
  FOREIGN KEY (articleAuthorId) REFERENCES author(authorId)
);