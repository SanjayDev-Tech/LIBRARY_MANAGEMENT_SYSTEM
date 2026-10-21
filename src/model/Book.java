package model;

public class Book {
    private String isbn;
    private String title;
    private String author;
    private String tag;
    private boolean isAvailable;

    public Book(String isbn, String title, String author, String tag) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.tag = tag;
        this.isAvailable = true;
    }

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    @Override
    public String toString() {
        String status = isAvailable ? "Available" : "Assigned";
        return "ISBN: " + isbn + " | Title: " + title + " | Author: " + author + " | Tag: " + tag + " | Status: " + status;
    }
}
