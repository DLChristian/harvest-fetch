package Harvest.Data;

import Harvest.Models.FarmerProduct;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FarmerProductJdbcTemplateRepository implements FarmerProductRepository{
    private final JdbcTemplate jdbcTemplate;

    public FarmerProductJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean add(FarmerProduct farmerProduct) {

        final String sql = "insert into farmer_product (farmer_id, product_id, price, organic) "
                + " values (?,?,?,?,?,?);";

        return jdbcTemplate.update(sql,
                farmerProduct.getFarmerId(),
                farmerProduct.getProductId(),
                farmerProduct.getPrice(),
                farmerProduct.isOrganic(),
                farmerProduct.isActive()) > 0;
    }
}
