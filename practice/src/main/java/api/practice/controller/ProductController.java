package api.practice.controller;

import api.practice.product.Product;
import api.practice.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;

    @GetMapping("/product/join")
    public String join() {
        return "getProduct";
    }

    @PostMapping("/product/join")
    public String join2(ProductForm form) {
        Product product = new Product();

        product.setName(form.getName());
        product.setStock(form.getStock());
        product.setPrice(form.getPrice());
        productRepository.join(product);

        return "redirect:/";
    }
}
