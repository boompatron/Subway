package com.atoz.subway.sandwich.repository;

import com.atoz.subway.sandwich.model.EggMayoSandwich;
import com.atoz.subway.sandwich.model.OrderStatus;
import com.atoz.subway.sandwich.model.PulledPorkSandwich;
import com.atoz.subway.sandwich.model.Sandwich;
import com.atoz.subway.topping.*;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.atoz.subway.JdbcUtils.*;

@Repository
@Primary
public class SandwichJdbcRepository implements SandwichRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;
    public SandwichJdbcRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public Sandwich save(Sandwich sandwich) {
        var saveStatus = jdbcTemplate.update(
                "insert into sandwiches(sandwich_id, sandwich_name, price, bread, cheese, meat, sauce, vegetable, order_status, created_at) "
                + "values(:sandwichId, :sandwichName, :price, :bread, :cheese, :meat, :sauce, :vegetable, :orderStatus, :createdAt)",
                toParamMap(sandwich));
        if (saveStatus != 1)
            throw new RuntimeException("save failed");
        return sandwich;
    }


    @Override
    public Sandwich findById(Long id) {
        return null;
    }

    @Override
    public List<Sandwich> findAll() {
        // jdbcTemplate.query("select * from sandwiches")
        return null;
    }

    @Override
    public void deleteAll() {
        jdbcTemplate.update("delete from sandwiches", Collections.emptyMap());
    }

    @Override
    public int count() {
        return 0;
    }

    private final static RowMapper<Sandwich> SandwichRowMapper = (resultSet, i) -> {
        var sandwichId = resultSet.getLong("sandwich_id");
        var sandwichName = resultSet.getString("sandwich_name");
        var bread = Bread.valueOf(resultSet.getString("bread"));
        var cheese = Cheese.valueOf(resultSet.getString("cheese"));
        var meat = Meat.valueOf(resultSet.getString("meat"));
        var sauce = Sauce.valueOf(resultSet.getString("sauce"));
        var vegetable = Vegetable.valueOf(resultSet.getString("vegetable"));
        var price = resultSet.getLong("price");
        var orderStatus = OrderStatus.valueOf(resultSet.getString("order_status"));
        var createdAt = toLocalDateTime(resultSet.getTimestamp("created_at"));

        if(sandwichName.equals("Pulled Pork"))
            return new PulledPorkSandwich(sandwichId, bread, cheese, meat, sauce, vegetable, price, orderStatus, createdAt);
        return new EggMayoSandwich(sandwichId, bread, cheese, meat, sauce, vegetable, price, orderStatus, createdAt);
    };

    private Map<String, Object> toParamMap(Sandwich sandwich){

        var paramMap = new HashMap<String, Object>();
        paramMap.put("sandwichId", sandwich.getId());
        paramMap.put("sandwichName", sandwich.getName());
        paramMap.put("bread", sandwich.getBread().toString());
        paramMap.put("cheese", sandwich.getBread().toString());
        paramMap.put("meat", sandwich.getMeat().toString());
        paramMap.put("sauce", sandwich.getSauce().toString());
        paramMap.put("vegetable", sandwich.getVegetable().toString());
        paramMap.put("price", sandwich.getPrice());
        paramMap.put("orderStatus", sandwich.getOrderStatus().toString());
        paramMap.put("createdAt", sandwich.getCreatedAt());
        return paramMap;
    }
}
