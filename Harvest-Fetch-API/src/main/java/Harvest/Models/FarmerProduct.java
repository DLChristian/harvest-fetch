package Harvest.Models;

import java.math.BigDecimal;

public class FarmerProduct {

    private int farmerId;
    private int productId;
    private BigDecimal price;
    private boolean organic;

    public FarmerProduct(int farmerId, int productId, BigDecimal price, boolean organic) {
        this.farmerId = farmerId;
        this.productId = productId;
        this.price = price;
        this.organic = organic;
    }

    public FarmerProduct() {
    }


    public int getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(int farmerId) {
        this.farmerId = farmerId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isOrganic() {
        return organic;
    }

    public void setOrganic(boolean organic) {
        this.organic = organic;
    }
}
