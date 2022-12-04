package com.atoz.subway.sandwich.model;

import com.atoz.subway.topping.*;
// import jakarta.persistence.Id;
import lombok.Getter;

import java.time.LocalDateTime;


@Getter
public abstract class Sandwich {
    // @Id
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
}
