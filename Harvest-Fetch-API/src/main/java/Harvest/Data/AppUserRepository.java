package Harvest.Data;

import Harvest.Models.AppUser;

import java.util.List;

public interface AppUserRepository {
    List<AppUser> findAll();

    AppUser findById(int userId);

    AppUser add(AppUser appUser);
}
