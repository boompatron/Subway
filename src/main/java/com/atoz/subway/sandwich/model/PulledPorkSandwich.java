package com.atoz.subway.sandwich.model;

import com.atoz.subway.topping.*;
import jakarta.persistence.Entity;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;



@Getter
public class PulledPorkSandwich extends Sandwich {
    public PulledPorkSandwich(
            Bread bread, Cheese cheese, Meat meat, Sauce sauce, Vegitable vegitable
            , OrderStatus orderStatus,LocalDateTime createdAt){
        this.name = "Pulled Pork Sandwich";
        this.bread = bread;
        this.cheese = cheese;
        this.meat = meat;
        this.sauce = sauce;
        this.vegitable = vegitable;
        this.orderStatus = orderStatus;
        this.createdAt = createdAt;
    }
}
