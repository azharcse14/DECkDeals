package com.azhar.deckdeals;

public class ItemModel {

    int productImage;
    String productName, percentage, brandName, branchName, distance, price, discountPrice, date;

    public ItemModel() {
    }

    public ItemModel(int productImage, String productName, String percentage, String brandName, String branchName, String distance, String price, String discountPrice, String date) {
        this.productImage = productImage;
        this.productName = productName;
        this.percentage = percentage;
        this.brandName = brandName;
        this.branchName = branchName;
        this.distance = distance;
        this.price = price;
        this.discountPrice = discountPrice;
        this.date = date;
    }

    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(String discountPrice) {
        this.discountPrice = discountPrice;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
