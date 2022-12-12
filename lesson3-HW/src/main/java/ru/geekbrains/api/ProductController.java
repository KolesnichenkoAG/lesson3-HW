package ru.geekbrains.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.model.Product;
import ru.geekbrains.repository.ProductRepository;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/all")
    public String getProduct(Model model) {
        List<Product> products = productRepository.generateProductList();
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping("/products/{id}")
    public String findProduct(Model model, @PathVariable Long id) {
        Product product = productRepository.findById(id);
        model.addAttribute("product", product);
        return "productsInfo";
    }
}
