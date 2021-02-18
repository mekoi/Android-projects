package com.example.bruno_brasil_irisi_meko_comp305_sec003_lab06;

public class Book {
    private String Title;
    private String Category;
    private double Price;
    private int Quantity;

    public Book(String title, String category, double price, int quantity) {
        Title=title;
        Category=category;
        Price=price;
        Quantity=quantity;
    }

    public Book() {
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }
}
