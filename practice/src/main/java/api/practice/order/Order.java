package api.practice.order;

import api.practice.product.Product;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(generator="uuid2")
    @GenericGenerator(name="uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name="order_member")
    private String member;

    @OneToMany(mappedBy = "order", cascade=CascadeType.ALL)
    @JoinColumn(name="products")
    private Product product;

    @Column(name="order_number")
    private int pNumber;

    public int total() {
        return (product.getPrice())*pNumber;
    }
}
