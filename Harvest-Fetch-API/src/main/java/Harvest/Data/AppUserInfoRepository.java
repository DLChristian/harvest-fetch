package Harvest.Data;

import Harvest.Models.AppUserInfo;

import java.util.List;

public interface AppUserInfoRepository {
    List<AppUserInfo> findAll();
}
