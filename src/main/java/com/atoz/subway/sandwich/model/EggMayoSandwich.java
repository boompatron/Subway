package com.atoz.subway.sandwich.model;

import com.atoz.subway.topping.*;
import lombok.Getter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Getter
@ToString
public class EggMayoSandwich extends Sandwich {
    public EggMayoSandwich(
            Bread bread, Cheese cheese, Meat meat, Sauce sauce, Vegetable vegetable,
            long price, OrderStatus orderStatus, LocalDateTime createdAt){
        this.name = "Egg Mayo";
        this.bread = bread;
        this.cheese = cheese;
        this.meat = meat;
        this.sauce = sauce;
        this.vegetable = vegetable;
        this.price = price;
        this.orderStatus = orderStatus;
        this.createdAt = createdAt;
    }

    public EggMayoSandwich(Long id,
                              Bread bread, Cheese cheese, Meat meat, Sauce sauce, Vegetable vegetable,
                              long price, OrderStatus orderStatus,LocalDateTime createdAt) {
        this.id = id;
        this.name = "Egg Mayo";
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
