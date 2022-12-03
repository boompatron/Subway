package com.atoz.subway.sandwich.model;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;


@Getter
public class PulledPorkSandwich extends Sandwich {
    public PulledPorkSandwich(Long id, String name, List<Object> toppings, OrderStatus orderStatus,LocalDateTime createdAt){
        this.id = id;
        this.name = name;
        this.orderStatus = orderStatus;
        this.toppings = toppings;
        this.createdAt = createdAt;
    }
}
