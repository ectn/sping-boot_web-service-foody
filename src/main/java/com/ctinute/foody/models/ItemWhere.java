package com.ctinute.foody.models;

public class ItemWhere {
    private int id;
    private String name;
    private String address;
    private String imageUrl;
    private double avgRating;
    private String noReview;
    private String noPhoto;
    private String noBookmark;
    private int cityID;
    private int districtId;
    private int streetId;
    private int categoryId;
    private int typeId;

    public ItemWhere() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(double avgRating) {
        this.avgRating = avgRating;
    }

    public String getNoReview() {
        return noReview;
    }

    public void setNoReview(String noReview) {
        this.noReview = noReview;
    }

    public String getNoPhoto() {
        return noPhoto;
    }

    public void setNoPhoto(String noPhoto) {
        this.noPhoto = noPhoto;
    }

    public String getNoBookmark() {
        return noBookmark;
    }

    public void setNoBookmark(String noBookmark) {
        this.noBookmark = noBookmark;
    }

    public int getCityID() {
        return cityID;
    }

    public void setCityID(int cityID) {
        this.cityID = cityID;
    }

    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }

    public int getStreetId() {
        return streetId;
    }

    public void setStreetId(int streetId) {
        this.streetId = streetId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }
}
