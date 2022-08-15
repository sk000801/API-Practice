package api.practice.order;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue
    private Long id;

    private String member;

    private String pName;

    private int pNumber;
}
