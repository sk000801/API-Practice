package api.practice.order;

import api.practice.product.Product;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name="order_product")
@NoArgsConstructor
public class ProductOrder {

//    @Id
//    @GeneratedValue(generator="uuid2")
//    @GenericGenerator(name="uuid2", strategy = "uuid2")
//    @Column(columnDefinition = "BINARY(16)")
    private UUID uuid = UUID.randomUUID();

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="order_product_id")
    private String id = uuid.toString();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="order_id")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="product_id")
    private Product product;

    private int pNumber; //주문수량

    public static ProductOrder create(int count, Product product) {
        ProductOrder productOrder = new ProductOrder();

        productOrder.setProduct(product);
        productOrder.setPNumber(count);

        return productOrder;
    }

    public int total() {
        return product.getPrice()*getPNumber();
    }

    public String toString() {
        return id.toString();
    }
}
