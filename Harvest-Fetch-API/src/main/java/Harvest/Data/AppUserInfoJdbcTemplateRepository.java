package Harvest.Data;

import Harvest.Data.mappers.AppUserInfoMapper;
import Harvest.Models.AppUserInfo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppUserInfoJdbcTemplateRepository implements AppUserInfoRepository {

    private final JdbcTemplate jdbcTemplate;

    public AppUserInfoJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<AppUserInfo> findAll(){
        final String sql = "select user_info_id, first_name, last_name, street_address, zip_code, city, state, email, phone, photo_url "
                + "from app_user_info;";
        return jdbcTemplate.query(sql, new AppUserInfoMapper());
    }


}
