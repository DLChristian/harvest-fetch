package Harvest.Models;

public class Farmer {


    private int farmerId;
    private String farmName;
    private String details;
    private String photoUrl;
    private int userId;

    public Farmer(int farmerId, String farmName, String photoUrl, String details, int userId) {
        this.farmerId = farmerId;
        this.farmName = farmName;
        this.photoUrl = photoUrl;
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
    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
