package com.atoz.subway.sandwich.model;

import com.atoz.subway.topping.*;
import lombok.Getter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Getter
@ToString
public class PulledPorkSandwich extends Sandwich {
    public PulledPorkSandwich(
            Bread bread, Cheese cheese, Meat meat, Sauce sauce, Vegetable vegetable,
            long price, OrderStatus orderStatus,LocalDateTime createdAt){
        this.name = "Pulled Pork";
        this.bread = bread;
        this.cheese = cheese;
        this.meat = meat;
        this.sauce = sauce;
        this.vegetable = vegetable;
        this.price = price;
        this.orderStatus = orderStatus;
        this.createdAt = createdAt;
    }

    public PulledPorkSandwich(Long id,
            Bread bread, Cheese cheese, Meat meat, Sauce sauce, Vegetable vegetable,
            long price, OrderStatus orderStatus,LocalDateTime createdAt) {
        this.id = id;
        this.name = "Pulled Pork";
        this.bread = bread;
        this.cheese = cheese;
        this.meat = meat;
        this.sauce = sauce;
        this.vegetable = vegetable;
        this.price = price;
        this.orderStatus = orderStatus;
        this.createdAt = createdAt;
    }
}
