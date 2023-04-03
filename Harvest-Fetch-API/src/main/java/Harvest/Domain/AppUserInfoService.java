package Harvest.Domain;

import Harvest.App;
import Harvest.Data.AppUserInfoRepository;
import Harvest.Data.FarmerRepository;
import Harvest.Models.AppUserInfo;
import Harvest.Models.Farmer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserInfoService {

    private final AppUserInfoRepository repository;

    public AppUserInfoService(AppUserInfoRepository repository) {
        this.repository = repository;
    }

    public List<AppUserInfo> findAll() {
        return repository.findAll();
    }

//    public Result<AppUserInfo> add(AppUserInfo appUserInfo) {
//        Result<AppUserInfo> result = validate(farmer);
//        if (!result.isSuccess()) {
//            return result;
//        }
//
//        if (farmer.getFarmerId() != 0) {
//            result.addMessage("farmerId cannot be set for `add` operation", ResultType.INVALID);
//            return result;
//        }
//
//        farmer = repository.add(farmer);
//        result.setPayload(farmer);
//        return result;
//    }


}
