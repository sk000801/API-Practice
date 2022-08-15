package api.practice.controller;

import api.practice.order.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @ResponseBody
    @RequestMapping("/")
    public Order test() {
        Order order = new Order();

        order.setPName("셔츠");
        order.setMember("임");
        order.setPNumber(10);

        return order;
    }
}
