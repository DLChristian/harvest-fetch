package Harvest.Data;

import Harvest.Data.mappers.AppUserMapper;
import Harvest.Models.AppUser;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class AppUserJdbcTemplateRepository implements AppUserRepository {
    private final JdbcTemplate jdbcTemplate;

    public AppUserJdbcTemplateRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<AppUser> findAll(){
        final String sql = "select user_id, user_name, first_name, last_name, street_address, zip_code, city, state, email, phone, photo_url "
                + "from app_user;";
        return jdbcTemplate.query(sql, new AppUserMapper());
    }

    @Override
    public AppUser findById(int userId) {

        final String sql = "select user_id, user_name, first_name, last_name, street_address, zip_code, city, state, email, phone, photo_url "
                + "from app_user "
                + "where user_id = ?;";

        return jdbcTemplate.query(sql, new AppUserMapper(), userId).stream()
                .findFirst()
                .orElse(null);
    }

    @Override
    public AppUser add(AppUser appUser) {

        final String sql = "insert into app_user (user_name, first_name, last_name, street_address, zip_code, city, state, email, phone, photo_url) "
                + " values (?,?,?,?,?,?,?,?,?,?);";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        int rowsAffected = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, appUser.getUserName());
            ps.setString(2, appUser.getFirstName());
            ps.setString(3, appUser.getLastName());
            ps.setString(4, appUser.getAddress());
            ps.setString(5, appUser.getZipCode());
            ps.setString(6, appUser.getCity());
            ps.setString(7, appUser.getState());
            ps.setString(8, appUser.getEmail());
            ps.setString(9, appUser.getPhone());
            ps.setString(10, appUser.getPhotoUrl());
            return ps;
        }, keyHolder);

        if (rowsAffected <= 0) {
            return null;
        }

        appUser.setUserId(keyHolder.getKey().intValue());
        return appUser;
    }
}
