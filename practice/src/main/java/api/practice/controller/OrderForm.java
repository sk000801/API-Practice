package api.practice.controller;


import api.practice.product.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class OrderForm {

    private UUID id;

    private Product product;

    private int pNumber;

    private String member;
}
