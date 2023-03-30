package Harvest.Domain;

import Harvest.Data.DataAccessException;
import Harvest.Data.FarmerRepository;
import Harvest.Models.Farmer;

import java.util.List;

public class FarmerService {

    private final FarmerRepository repository;

    public FarmerService(FarmerRepository repository) {
        this.repository = repository;
    }

    public List<Farmer> findAll() throws DataAccessException {
        return repository.findAll();
    }
}
