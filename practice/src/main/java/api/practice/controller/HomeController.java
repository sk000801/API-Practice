package api.practice.controller;

import api.practice.order.Order;
import api.practice.order.OrderRepository;
import api.practice.order.ProductOrder;
import api.practice.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @GetMapping("/")
    public String home(@CookieValue(name="mId", required = false) Long mId, Model model) {
        //이제 여기서 로그인과 비 로그인이 구분된 페이지가 있다면 구분해주겠지..?

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

        Order order = Order.create(form.getMember(), productOrder);
        orderRepository.join(order);
        return "redirect:/";
    }

}
