package com.java.io;

import java.util.Objects;

//1.(Set)编程：创建一个商品(Product)类,属性：商品名，商品单价，商品的数量，商品产地。
class Product {
    private String name;
    private Double price;
    private Integer amount;
    private String address;

    public Product() {
    }

    public Product(String name, Double price, Integer amount, String address) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) && Objects.equals(price, product.price) && Objects.equals(amount, product.amount) && Objects.equals(address, product.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, amount, address);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}