package com.atoz.subway.sandwich.model;

import com.atoz.subway.topping.*;
import lombok.Getter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Getter
public class PulledPorkSandwich extends Sandwich {
    public PulledPorkSandwich(LocalDateTime createdAt){
        this.name = "Pulled Pork";
        this.bread = Bread.WHEAT;
        this.cheese = Cheese.MOZZARELLA;
        this.meat = Meat.PULLED_PORK;
        this.sauce = Sauce.BARBEQUE;
        this.vegetable = Vegetable.LETTUCE;
        this.price = 5600L;
        this.orderStatus = OrderStatus.IN_ORDER;
        this.createdAt = createdAt;
    }

    public PulledPorkSandwich(Long id, LocalDateTime createdAt) {
        this.id = id;
        this.name = "Pulled Pork";
        this.bread = Bread.WHEAT;
        this.cheese = Cheese.MOZZARELLA;
        this.meat = Meat.PULLED_PORK;
        this.sauce = Sauce.BARBEQUE;
        this.vegetable = Vegetable.LETTUCE;
        this.price = 5600L;
        this.orderStatus = OrderStatus.IN_ORDER;
        this.createdAt = createdAt;
    }
}
