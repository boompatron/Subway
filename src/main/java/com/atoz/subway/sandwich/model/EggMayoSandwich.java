package com.atoz.subway.sandwich.model;

import com.atoz.subway.topping.*;
import lombok.Getter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Getter
@ToString
public class EggMayoSandwich extends Sandwich {
    public EggMayoSandwich(LocalDateTime createdAt){
        this.name = "Egg Mayo";
        this.bread = Bread.FLAT_BREAD;
        this.cheese = Cheese.SHRED;
        this.meat = Meat.BACON;
        this.sauce = Sauce.MAYONNAISE;
        this.vegetable = Vegetable.LETTUCE;
        this.price = 4500L;
        this.orderStatus = OrderStatus.IN_ORDER;
        this.createdAt = createdAt;
    }

    public EggMayoSandwich(Long id, LocalDateTime createdAt) {
        this.id = id;
        this.name = "Egg Mayo";
        this.bread = Bread.FLAT_BREAD;
        this.cheese = Cheese.SHRED;
        this.meat = Meat.BACON;
        this.sauce = Sauce.MAYONNAISE;
        this.vegetable = Vegetable.LETTUCE;
        this.price = 4500L;
        this.orderStatus = OrderStatus.IN_ORDER;
        this.createdAt = createdAt;
    }
}
