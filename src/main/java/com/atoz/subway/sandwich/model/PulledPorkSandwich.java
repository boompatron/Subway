package com.atoz.subway.sandwich.model;

import com.atoz.subway.topping.*;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;


@Getter
public class PulledPorkSandwich extends Sandwich {
    public PulledPorkSandwich(Long id, String name,
            Bread bread, Cheese cheese, Meat meat, Sauce sauce, Vegitable vegitable
            , OrderStatus orderStatus,LocalDateTime createdAt){
        this.id = id;
        this.name = name;
        this.bread = bread;
        this.cheese = cheese;
        this.meat = meat;
        this.sauce = sauce;
        this.vegitable = vegitable;
        this.orderStatus = orderStatus;
        this.createdAt = createdAt;
    }
}
