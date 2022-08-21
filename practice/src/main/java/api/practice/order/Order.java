package api.practice.order;

import api.practice.product.Product;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Getter
@Setter
@Entity
@Table(name="orders")
@RequiredArgsConstructor
public class Order {
//    @Id
//    @GeneratedValue(generator="uuid2")
//    @GenericGenerator(name="uuid2", strategy = "uuid2")
//    @Column(columnDefinition = "BINARY(16)")
    private UUID uuid = UUID.randomUUID();

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="order_id")
    private String id = uuid.toString();

    @Column(name="order_member")
    private String member;

    @OneToMany(mappedBy = "order")
    @JsonIgnore
    private List<ProductOrder> polists = new ArrayList<>();

    //cascade = CascadeType.ALL

    public void addProductOrder(ProductOrder productOrder) {
        polists.add(productOrder);
        productOrder.setOrder(this);
    }

    public static Order create(String member, ProductOrder... lists) {
        //여기에 뭔가 list에 대한 추가가 들어가야 할 거 같음...
        Order order = new Order();
        order.setMember(member);
        for(ProductOrder productOrder : lists) {
            order.addProductOrder(productOrder);
        }
        return order;
    }

    public int total() {
        int total = 0;
        for(ProductOrder productOrder : polists) {
            total += productOrder.total();
        }
        return total;
    }

    public String toString() {
        return id.toString();
    }
}
