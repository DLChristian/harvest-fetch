package Harvest.Data;

import Harvest.Models.Farmer;

import java.util.List;

public interface FarmerRepository {
    List<Farmer> findAll();

    Farmer findById(int farmerId);
}
