package api.practice.controller;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderForm {

    private Long id;

    private String pName;

    private int pNumber;

    private String member;
}
