package Harvest.Data;

import Harvest.Data.mappers.AppUserMapper;
import Harvest.Models.AppUser;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class AppUserJdbcTemplateRepository implements AppUserRepository {
    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<AppUser> mapper = (resultSet, index) -> {
        AppUser user = new AppUser();
        user.setAppUserId(resultSet.getInt("app_user_id"));
        user.setUserName(resultSet.getString("username"));
        user.setPassword(resultSet.getString("password_hash"));
        return user;
    };

    public AppUserJdbcTemplateRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }


    public AppUser findByUserName(String userName) {

        String sql = "select app_user_id, username, password_hash from app_user where username = ?;";
        AppUser user = jdbcTemplate.query(sql, mapper, userName).stream()
                .findFirst().orElse(null);

        if (user != null) {
            addAuthorities(user);
        }
        return user;
    }

    private void addAuthorities(AppUser user) {

        String sql = "select a.name "
                + "from app_user_authority aua "
                + "inner join app_authority a on aua.app_authority_id = a.app_authority_id "
                + "where aua.app_user_id = ?";

        List<String> authorities = jdbcTemplate.query(
                sql,
                (rs, i) -> rs.getString("name"),
                user.getAppUserId()
        );
        user.addAuthorities(authorities);
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

        final String sql = "insert into app_user (user_name, password_hash) "
                + " values (?,?);";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        int rowsAffected = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, appUser.getUsername());
            ps.setString(2, appUser.getPassword());
            return ps;
        }, keyHolder);

        if (rowsAffected <= 0) {
            return null;
        }

        appUser.setAppUserId(keyHolder.getKey().intValue());
        return appUser;
    }
}
