package api.practice.controller;

import api.practice.order.Order;
import api.practice.order.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderRepository orderRepository;

    @ResponseBody
    @RequestMapping("/order/list")
    public List<Order> test() {

        List<Order> lists = orderRepository.list();

        //list 뽑아낼 때 아마도 productorder에 order가 포함돼 있으니
        //productOrder를 사용해 createQuery를 하는게 좋지 않나

        return lists;
    }


}
