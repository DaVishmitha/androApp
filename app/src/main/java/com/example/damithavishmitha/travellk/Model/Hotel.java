package com.example.damithavishmitha.travellk.Model;

/**
 * Created by DamithaVishmitha on 3/15/2018.
 */

public class Hotel {
    private String Name, Image, Description, Price, Discount, LocationID;

    public Hotel() {
    }

    public Hotel(String name, String image, String description, String price, String discount, String locationID) {
        Name = name;
        Image = image;
        Description = description;
        Price = price;
        Discount = discount;
        LocationID = locationID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getDiscount() {
        return Discount;
    }

    public void setDiscount(String discount) {
        Discount = discount;
    }

    public String getLocationID() {
        return LocationID;
    }

    public void setLocationID(String locationID) {
        LocationID = locationID;
    }
}
