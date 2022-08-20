package api.practice.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@RequiredArgsConstructor
@Transactional
@Repository
public class ProductOrderRepository {

    private final EntityManager em;

    public void join(ProductOrder productOrder) {
        em.persist(productOrder);
    }

    public List<ProductOrder> list() {
        return em.createQuery("select po from ProductOrder as po", ProductOrder.class)
                .getResultList();
    }
}
