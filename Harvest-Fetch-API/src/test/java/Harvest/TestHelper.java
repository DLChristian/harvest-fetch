package Harvest;

import Harvest.Domain.Result;
import Harvest.Domain.ResultType;
import Harvest.Models.FarmerProduct;

import java.math.BigDecimal;

public class TestHelper {
    public static <T> Result<T> makeResult(String message, ResultType type) {
        Result<T> result = new Result<>();
        result.addMessage(message, type);
        return result;
    }

    public static <T> Result<T> makeResult(T payload) {
        Result<T> result = new Result<>();
        result.setPayload(payload);
        return result;
    }

    FarmerProduct makeFarmerProduct(){
        FarmerProduct farmerProduct = new FarmerProduct();
        farmerProduct.setFarmerId(5);
        farmerProduct.setProductId(1);
        farmerProduct.setPrice(BigDecimal.valueOf(2.93));
        farmerProduct.isActive(1);
        farmerProduct.isOrganic(true);
        return farmerProduct;
    }

}
