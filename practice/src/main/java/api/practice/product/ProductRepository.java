package api.practice.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Transactional
public class ProductRepository {

    private final EntityManager em;

    public void join(Product product) {
        em.persist(product);
    }

    public List<Product> list() {
        return em.createQuery("select p from Product as p")
                .getResultList();
    }
}
