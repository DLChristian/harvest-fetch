package Harvest.Data;

import Harvest.Data.mappers.FarmerMapper;
import Harvest.Models.Farmer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FarmerJdbcTemplateRepository implements FarmerRepository {
    private final JdbcTemplate jdbcTemplate;
    public FarmerJdbcTemplateRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Farmer> findAll(){
        final String sql = "select farmer_id, farm_name, farm_photo_url, details, user_id "
                + "from farmer;";
        return jdbcTemplate.query(sql, new FarmerMapper());
    }

    @Override
    public Farmer findById(int farmerId) {

        final String sql = "select farmer_id, farm_name, farm_photo_url, details, user_id "
                + "from farmer "
                + "where farmer_id = ?;";

        return jdbcTemplate.query(sql, new FarmerMapper(), farmerId).stream()
                .findFirst()
                .orElse(null);
    }
}
