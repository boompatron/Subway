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
        if(!id.equals(sandwich.id))
            log.info("id");
        if(!meat.equals(sandwich.meat))
            log.info("meat");
        if(!cheese.equals(sandwich.cheese))
            log.info("cheese");
        if(!sauce.equals(sandwich.sauce))
            log.info("sauce");
        if(!vegetable.equals(sandwich.vegetable))
            log.info("vegetable");
        if(!price.equals(sandwich.price))
            log.info("price");
        if(!orderStatus.equals(sandwich.orderStatus))
            log.info("os");
        if(!name.equals(sandwich.name))
            log.info("name");
        if(!createdAt.equals(sandwich.createdAt))
            log.info("created_at");

        return (id.equals(sandwich.id)) && (name.equals(sandwich.name)) && (bread.equals(sandwich.bread)) && (cheese.equals(sandwich.cheese))
                && (meat.equals(sandwich.meat)) && (sauce.equals(sandwich.sauce)) && (vegetable.equals(sandwich.vegetable))
                && (price.equals(sandwich.price)) && (orderStatus.equals( sandwich.orderStatus)) && (createdAt.equals(sandwich.createdAt));
    }
}
