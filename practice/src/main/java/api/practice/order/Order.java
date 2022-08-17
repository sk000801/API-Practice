package api.practice.order;

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

    @Column(name="order_product")
    private String pName;

    @Column(name="order_number")
    private int pNumber;
}
