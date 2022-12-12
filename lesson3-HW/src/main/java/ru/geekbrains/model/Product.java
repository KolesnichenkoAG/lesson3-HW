package ru.geekbrains.model;

public class Product {
    //private static Long counter = 1l;
    private Long id;
    private String title;
    private Integer cost;

    public Product(Long id, String title, Integer cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getCost() {
        return cost;
    }
}
