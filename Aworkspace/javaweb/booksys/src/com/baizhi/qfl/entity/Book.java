package com.baizhi.qfl.entity;

import java.io.Serializable;

public class Book implements Serializable {
    private Integer bookId;
    private String bookName;
    private Double price;
    private String category;
    private String detial;

    public Book() {
    }

    public Book(Integer bookId, String bookName, Double price, String category, String detial) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.price = price;
        this.category = category;
        this.detial = detial;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", detial='" + detial + '\'' +
                '}';
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDetial() {
        return detial;
    }

    public void setDetial(String detial) {
        this.detial = detial;
    }
}
