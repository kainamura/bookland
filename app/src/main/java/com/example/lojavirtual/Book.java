package com.example.lojavirtual;

public class Book {
    private String name;
    private String description;
    private String author;
    private String year;
    private String gender;
    private String publisher;
    private String price;
    private final int imageResource;

    public Book(String name, String desc, int imageResource, String author, String gender, String year, String publisher, String p) {
        this.name = name;
        this.description = desc;
        this.imageResource = imageResource;
        this.author = author;
        this.gender = gender;
        this.year = year;
        this.publisher = publisher;
        this.price = p;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
