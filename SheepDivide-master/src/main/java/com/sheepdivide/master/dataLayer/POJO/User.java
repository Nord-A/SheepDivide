package com.sheepdivide.master.dataLayer.POJO;

public class User {
    private int userId, availableSheepPoints, currentSheepPoints;
    private double percentShare;

    public User() {
    }

    public User(int userId, double percentShare) { //, int availableSheepPoints
        this.userId = userId;
        this.percentShare = percentShare;
        //this.availableSheepPoints = availableSheepPoints;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getPercentShare() {
        return percentShare;
    }

    public void setPercentShare(double percentShare) {
        this.percentShare = percentShare;
    }

    public int getAvailableSheepPoints() {
        return availableSheepPoints;
    }

    public void setAvailableSheepPoints(int availableSheepPoints) {
        this.availableSheepPoints = availableSheepPoints;
    }

    public int getCurrentSheepPoints() {
        return currentSheepPoints;
    }

    public void setCurrentSheepPoints(int currentSheepPoints) {
        this.currentSheepPoints = currentSheepPoints;
    }
}
