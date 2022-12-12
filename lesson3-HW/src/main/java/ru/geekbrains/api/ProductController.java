package ru.geekbrains.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.model.Product;
import ru.geekbrains.repository.ProductRepository;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/all")
    public String showProduct(Model model) {
        model.addAttribute("products", productRepository.getAllProducts());
        return "productsAll";
    }

    @GetMapping("/products/{id}")
    public String findProduct(Model model, @PathVariable Long id) {
        Product product = productRepository.findById(id);
        model.addAttribute("product", product);
        return "productsInfo";
    }

    @GetMapping("/show_form")
    public String showFormPage() {
        return "simple_form";
    }

    @GetMapping("/prod_add")
    public String addProduct(@RequestParam Long id, @RequestParam String title, @RequestParam Integer cost) {
        Product product = new Product(id, title, cost);
        productRepository.add(product);
        return "redirect:/products/all";
    }
}
