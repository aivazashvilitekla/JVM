package sample;


public class RealEstate {
    public int id;
    public String dealType;
    public String location;
    public String district;
    public String propertyType;
    public float numberOfRooms;
    public String price;
    public String email;
    public String mobile;
    public String text;

    public int getId() {
        return id;
    }

    public String getDealType() {
        return dealType;
    }

    public String getLocation() {
        return location;
    }

    public String getDistrict() {
        return district;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public float getNumberOfRooms() {
        return numberOfRooms;
    }

    public String getPrice() {
        return price;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public String getText() {
        return text;
    }

    public RealEstate(int id, String dealType, String location, String district, String propertyType, float numberOfRooms, String price, String email, String mobile, String text) {
        this.id = id;
        this.dealType = dealType;
        this.location = location;
        this.district = district;
        this.propertyType = propertyType;
        this.numberOfRooms = numberOfRooms;
        this.price = price;
        this.email = email;
        this.mobile = mobile;
        this.text = text;
    }
}
