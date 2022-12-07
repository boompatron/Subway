package com.atoz.subway.sandwich.model;

import com.atoz.subway.topping.*;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
public class CustomSandwich extends Sandwich {
    public CustomSandwich(
                          Bread bread, Cheese cheese, Meat meat, Sauce sauce, Vegetable vegetable,
                          long price, OrderStatus orderStatus, LocalDateTime createdAt){
        this.name = "Custom Sandwich";
        this.bread = bread;
        this.cheese = cheese;
        this.meat = meat;
        this.sauce = sauce;
        this.vegetable = vegetable;
        this.price = price;
        this.orderStatus = orderStatus;
        this.createdAt = createdAt;
    }
    public CustomSandwich(Long id,
                          Bread bread, Cheese cheese, Meat meat, Sauce sauce, Vegetable vegetable,
                          long price, OrderStatus orderStatus, LocalDateTime createdAt){
        this.id = id;
        this.name = "Custom Sandwich";
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
