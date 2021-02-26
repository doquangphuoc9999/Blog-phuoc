package Model;

import java.time.LocalDateTime;

public class Post {
    private int idPost;
    private String title;
    private String fullContent;
    private String shortContent;
    private LocalDateTime publisht;
    private String image;
    private Author author;
    private Category category;

    public Post(String title, String fullContent, String shortContent,String image, Category category) {
        this.title = title;
        this.fullContent = fullContent;
        this.shortContent = shortContent;
        this.image = image;
        this.category = category;
    }
    public Post(int idPost, String title, String fullContent, String shortContent, String image, Author author, Category category) {
        this.idPost = idPost;
        this.title = title;
        this.fullContent = fullContent;
        this.shortContent = shortContent;
        this.image = image;
        this.author = author;
        this.category = category;
    }


    public Post(int idPost, String title, String fullContent, String shortContent, LocalDateTime publisht, String image, Author author, Category category) {
        this.idPost = idPost;
        this.title = title;
        this.fullContent = fullContent;
        this.shortContent = shortContent;
        this.publisht = publisht;
        this.image = image;
        this.author = author;
        this.category = category;
    }
    public Post( String title, String fullContent, String shortContent, String image, Author author, Category category) {
        this.title = title;
        this.fullContent = fullContent;
        this.shortContent = shortContent;
        this.image = image;
        this.author = author;
        this.category = category;
    }

    public Post(String title, String fullContent, String shortContent, LocalDateTime publisht, String image, Author author, Category category) {
        this.title = title;
        this.fullContent = fullContent;
        this.shortContent = shortContent;
        this.publisht = publisht;
        this.image = image;
        this.author = author;
        this.category = category;
    }

    public Post(String title, String fullContent, String shortContent, String image) {
        this.title = title;
        this.fullContent = fullContent;
        this.shortContent = shortContent;
        this.image = image;
    }
    public Post(int idPost,String title, String fullContent, String shortContent, String image, Category category) {
        this.idPost = idPost;
        this.title = title;
        this.fullContent = fullContent;
        this.shortContent = shortContent;
        this.image = image;
        this.category = category;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Post(int id, String title, String fullContent, String shortContent, LocalDateTime publisht, String image, Category category) {
        this.idPost = id;
        this.title = title;
        this.fullContent = fullContent;
        this.shortContent = shortContent;
        this.publisht = publisht;
        this.image = image;
        this.category = category;
    }

    public Post() {
    }

    public int getIdPost() {
        return idPost;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFullContent() {
        return fullContent;
    }

    public void setFullContent(String fullContent) {
        this.fullContent = fullContent;
    }

    public String getShortContent() {
        return shortContent;
    }

    public void setShortContent(String shortContent) {
        this.shortContent = shortContent;
    }

    public LocalDateTime getPublisht() {
        return publisht;
    }

    public void setPublisht(LocalDateTime publisht) {
        this.publisht = publisht;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
