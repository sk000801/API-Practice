package api.practice.controller;

import api.practice.product.Product;
import api.practice.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController2 {

    private final ProductRepository productRepository;

    @ResponseBody
    @RequestMapping("/product/list")
    public List<Product> list() {

        List<Product> lists = productRepository.list();

        return lists;
    }

}
