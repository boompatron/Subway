package com.atoz.subway.sandwich.controller.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class SandwichRestApi {
   @GetMapping("/sandwiches")
   public String ListPage(){
       return "list-page";
   }
}
