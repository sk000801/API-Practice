package api.practice.controller;


import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class OrderForm {

    private UUID id;

    private String pName;

    private int pNumber;

    private String member;
}
