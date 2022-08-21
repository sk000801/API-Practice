package api.practice.controller;

import api.practice.product.Product;
import api.practice.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;

    @GetMapping("/product/order")
    public String order(Model model) {
        List<Product> products = productRepository.list();
        model.addAttribute("products", products);
        return "home2";
    }

    @PostMapping("/product/order")
    public String order2(OPForm form) {
        String id = form.getId();
        System.out.println("id = " + id);
        return "redirect:/order/"+id+"/join";
    }

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
