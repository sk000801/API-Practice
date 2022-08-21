package api.practice.controller;

import api.practice.order.Order;
import api.practice.order.OrderRepository;
import api.practice.order.ProductOrder;
import api.practice.order.ProductOrderRepository;
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
    private final ProductOrderRepository productOrderRepository;

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
        productOrder.setProduct(productRepository.findId(id));
        //사실 잘 이해가 안간다.. 굳이 설정을 또??
        productOrderRepository.join(productOrder);

        Order order = Order.create(form.getMember(), productOrder);
        orderRepository.join(order);
        return "redirect:/";
    }

}
