package ru.geekbrains.repository;

import org.springframework.stereotype.Repository;
import ru.geekbrains.model.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> products;

    /*public void init() {
        products = new ArrayList<>(Arrays.asList(
                new Product( "Bread", 120),
                new Product( "Milk", 500),
                new Product( "Apples", 350),
                new Product( "Sugar", 600),
                new Product( "Cheese", 3500)
        ));
    }*/
    public List<Product> generateProductList() {
        return List.of(
            new Product("Milk", 850),
            new Product("Sugar", 750),
            new Product("Bread", 120),
            new Product("Cheese", 2500),
            new Product("Meat", 3500)
        );
    }

    public Product findById(Long id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow(() -> new RuntimeException());

    }

    public String printListProduct () {
        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i));
        }
        return null;
    }
}
