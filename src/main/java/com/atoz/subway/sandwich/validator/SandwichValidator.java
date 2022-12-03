
package com.atoz.subway.sandwich.validator;

import com.atoz.subway.sandwich.model.Sandwich;
import com.atoz.subway.topping.Cheese;
import com.atoz.subway.topping.Meat;
import com.atoz.subway.topping.Sauce;
import com.atoz.subway.topping.Vegitable;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

public class SandwichValidator implements Predicate<Sandwich> {

    @Override
    public boolean test(Sandwich sandwich) {
//        AtomicInteger meatCount = new AtomicInteger();
//        AtomicInteger sauceCount = new AtomicInteger() ;
//        AtomicInteger vegiCount = new AtomicInteger();
//        AtomicInteger cheeseCount = new AtomicInteger();
//        List<Object> toppingList = sandwich.getToppings();
//
//        toppingList.forEach(t -> {
//            if      (t instanceof Meat) meatCount.getAndIncrement();
//            else if (t instanceof Vegitable) vegiCount.getAndIncrement();
//            else if (t instanceof Sauce) sauceCount.getAndIncrement();
//            else if (t instanceof Cheese) cheeseCount.getAndIncrement();
//        });
//
//        if(cheeseCount.get() > 1 || meatCount.get() > 1 || vegiCount.get() > 1 || sauceCount.get() > 1)
//            return false;
//
        return true;
    }
}
