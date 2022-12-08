package com.atoz.subway.sandwich.model;

import com.atoz.subway.topping.*;
// import jakarta.persistence.Id;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;


@Getter
@Slf4j
public abstract class Sandwich {
    protected Long id;
    protected String name;
    protected Bread bread;
    protected Cheese cheese;
    protected Meat meat;
    protected Sauce sauce;
    protected Vegetable vegetable;
    protected Long price;
    protected OrderStatus orderStatus;
    protected LocalDateTime createdAt;

    public String toString() {
        return "ID : " + id + ", Name : " + name + ", Price : " + price + ", Bread : " + bread.toString()
                + ", Cheese : " + cheese.toString() + ", Meat : " + meat.toString()
                + ", Sauce : " + sauce.toString() + "Vegetable : " + vegetable.toString()
                + ", order status : " + orderStatus.toString() + ", created at + " + createdAt.toString();
    }

    public boolean isSame(Sandwich sandwich){
        return (id.equals(sandwich.id)) && (name.equals(sandwich.name)) && (bread.equals(sandwich.bread)) && (cheese.equals(sandwich.cheese))
                && (meat.equals(sandwich.meat)) && (sauce.equals(sandwich.sauce)) && (vegetable.equals(sandwich.vegetable))
                && (price.equals(sandwich.price)) && (orderStatus.equals( sandwich.orderStatus)) && (createdAt.equals(sandwich.createdAt));
    }
}
