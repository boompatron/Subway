package com.atoz.subway.sandwich.model;

import com.atoz.subway.topping.*;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Getter
public abstract class Sandwich {
    @Id
    protected long id;
    protected String name;
    protected Bread bread;
    protected Cheese cheese;
    protected Meat meat;
    protected Sauce sauce;
    protected Vegitable vegitable;
    protected OrderStatus orderStatus;
    protected LocalDateTime createdAt;
}
