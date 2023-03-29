package Harvest.Models;

public class Farmer {

    private int farmerId;
    private String farmName;
    private String details;
    private int userId;

    public Farmer(int farmerId, String farmName, String details, int userId) {
        this.farmerId = farmerId;
        this.farmName = farmName;
        this.details = details;
        this.userId = userId;
    }

    public Farmer() {
    }


    public int getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(int farmerId) {
        this.farmerId = farmerId;
    }

    public String getFarmName() {
        return farmName;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
