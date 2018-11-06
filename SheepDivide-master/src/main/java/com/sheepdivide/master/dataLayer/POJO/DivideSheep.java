package com.sheepdivide.master.dataLayer.POJO;

public class DivideSheep {
    private String sheepId;
    private int userId, sheepPoints;

    public DivideSheep() {
    }

    public DivideSheep(String sheepId, int sheepPoints) {
        this.sheepId = sheepId;
        this.sheepPoints = sheepPoints;
    }

    public DivideSheep(String sheepId, int sheepPoints, int userId) {
        this.sheepId = sheepId;
        this.sheepPoints = sheepPoints;
        this.userId = userId;
    }

    public String getSheepId() {
        return sheepId;
    }

    public void setSheepId(String sheepId) {
        this.sheepId = sheepId;
    }

    public int getSheepPoints() {
        return sheepPoints;
    }

    public void setSheepPoints(int sheepPoints) {
        this.sheepPoints = sheepPoints;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
