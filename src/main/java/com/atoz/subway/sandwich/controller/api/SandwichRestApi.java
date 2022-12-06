package com.atoz.subway.sandwich.controller.api;

import com.atoz.subway.sandwich.model.Sandwich;
import com.atoz.subway.sandwich.service.SandwichService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SandwichRestApi {
    private final SandwichService service;

    public SandwichRestApi(SandwichService service) {
        this.service = service;
    }

    @GetMapping("/api/v1/sandwiches")
    public List<Sandwich> sandwichList(){
        return service.findAll();
    }
}
