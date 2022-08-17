package api.practice.controller;

import api.practice.order.Order;
import api.practice.order.OrderRepository;
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

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/order/{id}/join")
    public String home2(@PathVariable("id") UUID id) {
        return "getOrder";
    }

    @PostMapping("/order/join")
    public String home2(OrderForm form) {
        Order order = new Order();

        order.setMember(form.getMember());
        order.setPName(form.getPName());
        order.setPNumber(form.getPNumber());

        orderRepository.join(order);
        return "home";
    }

}
