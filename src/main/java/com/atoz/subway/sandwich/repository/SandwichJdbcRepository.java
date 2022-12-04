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

import java.util.*;

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
    @Transactional
    public Optional<Sandwich> findById(Long id) {
        try {
            return Optional.ofNullable(
                    jdbcTemplate.queryForObject("select * from sandwiches where sandwich_id = :sandwichId",
                            Collections.singletonMap("sandwichId", id),
                            sandwichRowMapper)
            );
        }catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Sandwich> findAll() {
        return jdbcTemplate.query("select * from sandwiches", sandwichRowMapper);
    }

    @Override
    public void deleteAll() {
        jdbcTemplate.update("delete from sandwiches", Collections.emptyMap());
    }

    @Override
    public int count() {
        return jdbcTemplate.queryForObject("select count(*) from sandwiches", Collections.emptyMap(), Integer.class);
    }

    @Override
    @Transactional
    public Sandwich update(Sandwich sandwich) {
        var updateState = jdbcTemplate.update(
                "update sandwiches set bread = :bread, cheese = :cheese, meat = :meat, sauce = :sauce, vegetable = :vegetable "
                         + ", price = :price, order_status = :orderStatus "
                 + "where sandwich_id = :sandwichId",
                toParamMap(sandwich)
        );
        if(updateState != 1)
            throw new RuntimeException("update Failed!!");
        return sandwich;
    }


    public List<Long> getIds(){
        var sandwiches = findAll();
        List<Long> ids = new ArrayList<>();
        sandwiches.forEach(s -> ids.add(s.getId()));
        return ids;
    }

    private final static RowMapper<Sandwich> sandwichRowMapper = (resultSet, i) -> {
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
        paramMap.put("cheese", sandwich.getCheese().toString());
        paramMap.put("meat", sandwich.getMeat().toString());
        paramMap.put("sauce", sandwich.getSauce().toString());
        paramMap.put("vegetable", sandwich.getVegetable().toString());
        paramMap.put("price", sandwich.getPrice());
        paramMap.put("orderStatus", sandwich.getOrderStatus().toString());
        paramMap.put("createdAt", sandwich.getCreatedAt());

        return paramMap;
    }
}
