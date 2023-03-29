package Harvest.Data.mappers;

import Harvest.Models.AppUser;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AppUserMapper implements RowMapper<AppUser> {
    @Override
    public AppUser mapRow(ResultSet rs, int rowNum) throws SQLException {
        AppUser appUser = new AppUser();
        appUser.setAppUserId(rs.getInt("user_id"));
        appUser.setUserName(rs.getString("user_name"));
        appUser.setFirstName(rs.getString("first_name"));
        appUser.setLastName(rs.getString("last_name"));
        appUser.setAddress(rs.getString("street_address"));
        appUser.setZipCode(rs.getString("zip_code"));
        appUser.setCity(rs.getString("city"));
        appUser.setState(rs.getString("state"));
        appUser.setEmail(rs.getString("email"));
        appUser.setPhone(rs.getString("phone"));
        appUser.setPhotoUrl(rs.getString("photo_url"));
        return appUser;
    }
}
