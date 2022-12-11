package ru.geekbrains.model;

public class Product {
    private static Long counter = 1l;
    private Long id;
    private String title;
    private int cost;

    public Product(String title, int cost) {
        this.id = counter++;
        this.title = title;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getCost() {
        return cost;
    }
}
