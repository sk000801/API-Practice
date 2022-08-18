package api.practice.controller;

import api.practice.order.Order;
import api.practice.order.OrderRepository;
import api.practice.order.ProductOrder;
import api.practice.product.Product;
import api.practice.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/order/{id}/join")
    public String home2(@PathVariable("id") String id) {
        return "getOrder";
    }

    @PostMapping("/order/{id}/join")
    public String home2(OrderForm form, @PathVariable("id") String id) {

        ProductOrder productOrder = ProductOrder.create(form.getPNumber(), productRepository.findId(id));
        Order order = Order.create(form.getMember(), productOrder);

        orderRepository.join(order);
        return "redirect:/";
    }

}
