package ru.geekbrains.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import ru.geekbrains.model.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>(Arrays.asList(
                new Product( 1L,"Bread", 120),
                new Product( 2L,"Milk", 500),
                new Product( 3L,"Apples", 350),
                new Product( 4L,"Sugar", 600),
                new Product( 5L,"Cheese", 3500)
        ));
    }

    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(products);
    }

    /*public List<Product> generateProductList() {
        return List.of(
            new Product("Milk", 850),
            new Product("Sugar", 750),
            new Product("Bread", 120),
            new Product("Cheese", 2500),
            new Product("Meat", 3500)
        );
    }*/

    public Product findById(Long id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow(() -> new RuntimeException());

    }

    public String printListProduct () {
        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i));
        }
        return null;
    }

    public void add(Product p) {
        products.add(p);
    }
}
