package org.bookpub.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by MaMingJiang on 2016/2/16.
 */
@Entity
public class Book {
    @Id
    @GeneratedValue
    private Long id;

    private String isbn;

    private String title;

    private String description;

    @ManyToOne
    private Author author;

    @ManyToOne
    private Publisher publisher;

    @ManyToMany
    private List<Reviewer> reviewers;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Publisher getpublisher() {
        return publisher;
    }

    public void setpublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public List<Reviewer> getReviewers() {
        return reviewers;
    }

    public void setReviewers(List<Reviewer> reviewers) {
        this.reviewers = reviewers;
    }

    public Book() {
    }

    public Book(String isbn, String title, String description, Author author, Publisher publisher) {
        this.isbn = isbn;
        this.title = title;
        this.description = description;
        this.author = author;
        this.publisher = publisher;
    }
}
