package com.atoz.subway.sandwich.controller;

import com.atoz.subway.sandwich.model.OrderStatus;
import com.atoz.subway.topping.*;

public record SandwichDto(
        String name,
        Bread bread,
        Cheese cheese,
        Meat meat,
        Sauce sauce,
        Vegetable vegetable,
        long price,
        OrderStatus orderStatus) {
}
