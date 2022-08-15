package api.practice.order;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name="order_member")
    private String member;

    @Column(name="order_product")
    private String pName;

    @Column(name="order_number")
    private int pNumber;
}
