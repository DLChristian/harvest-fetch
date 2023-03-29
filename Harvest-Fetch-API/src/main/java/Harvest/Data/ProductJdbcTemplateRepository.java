package Harvest.Data;

import Harvest.Data.mappers.ProductMapper;
import Harvest.Models.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductJdbcTemplateRepository implements ProductRepository {
    private final JdbcTemplate jdbcTemplate;

    public ProductJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Product> findAll(){
        final String sql = "select product_id, product_name, picture_url from product;";
        return jdbcTemplate.query(sql, new ProductMapper());
    }

}
