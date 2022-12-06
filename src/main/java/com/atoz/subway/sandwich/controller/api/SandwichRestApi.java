package com.atoz.subway.sandwich.controller.api;

import com.atoz.subway.sandwich.controller.SandwichDto;
import com.atoz.subway.sandwich.model.CustomSandwich;
import com.atoz.subway.sandwich.model.EggMayoSandwich;
import com.atoz.subway.sandwich.model.PulledPorkSandwich;
import com.atoz.subway.sandwich.model.Sandwich;
import com.atoz.subway.sandwich.service.SandwichService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
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

    @PostMapping("/api/v1/sandwiches/new")
    public Sandwich newSandwich(@RequestBody SandwichDto dto){
        if(dto.name().equals("Pulled Pork"))
            return service.save(new PulledPorkSandwich(LocalDateTime.now()));
        else if(dto.name().equals("Egg Mayo"))
            return service.save(new EggMayoSandwich(LocalDateTime.now()));
        else
            return new CustomSandwich(dto.bread(), dto.cheese(), dto.meat(), dto.sauce(), dto.vegetable(), dto.price(),
                    dto.orderStatus(), LocalDateTime.now());
    }
}
