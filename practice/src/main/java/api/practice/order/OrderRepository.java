package api.practice.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class OrderRepository {

    private final EntityManager em;

    public void join(Order order) {
        em.persist(order);
    }

    public List<Order> list() {
        return em.createQuery("select o from Order as o", Order.class)
                .getResultList();
    }
}
