package Harvest.Domain;

<<<<<<< HEAD
import Harvest.Data.FarmerRepository;
import Harvest.Models.Farmer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmerService {
=======
import Harvest.Data.DataAccessException;
import Harvest.Data.FarmerRepository;
import Harvest.Models.Farmer;

import java.util.List;

public class FarmerService {

>>>>>>> 3511079e26ef0d877534f474682ef03372312880
    private final FarmerRepository repository;

    public FarmerService(FarmerRepository repository) {
        this.repository = repository;
    }

<<<<<<< HEAD
    public List<Farmer> findAll(){
        return repository.findAll();
    }

    public Farmer findById(int farmerId){
        return repository.findById(farmerId);
    }

    public Result<Farmer> add(Farmer farmer){
        Result<Farmer> result = validate(farmer);
        if(!result.isSuccess()){
            return result;
        }

        if(farmer.getFarmerId() != 0){
            result.addMessage("farmerId cannot be set for `add` operation", ResultType.INVALID);
            return result;
        }

        farmer = repository.add(farmer);
        result.setPayload(farmer);
        return result;
    }

    public Result<Farmer> update(Farmer farmer){
        Result<Farmer> result = validate(farmer);
        if(!result.isSuccess()){
            return result;
        }
        if(farmer.getFarmerId() <= 0){
            result.addMessage("farmerId must be set for `update` operation", ResultType.INVALID);
            return result;
        }
        if (!repository.update(farmer)){
            String msg = String.format("farmerId: %s, not found", farmer.getFarmerId());
            result.addMessage(msg, ResultType.NOT_FOUND);
        }

        return result;
    }

    public boolean deleteById(int farmerId){
        return repository.deleteById(farmerId);
    }

    private Result<Farmer> validate(Farmer farmer){
        Result<Farmer> result = new Result<>();
        if (farmer == null){
            result.addMessage("farmer cannot be null", ResultType.INVALID);
            return result;
        }

        if (Validations.isNullOrBlank(farmer.getFarmName())){
            result.addMessage("Farm name is required", ResultType.INVALID);
        }

        if(Validations.isNullOrBlank(farmer.getDetails())){
            result.addMessage("Farm details are required", ResultType.INVALID);
        }

        return result;
    }
=======
    public List<Farmer> findAll() throws DataAccessException {
        return repository.findAll();
    }
>>>>>>> 3511079e26ef0d877534f474682ef03372312880
}
