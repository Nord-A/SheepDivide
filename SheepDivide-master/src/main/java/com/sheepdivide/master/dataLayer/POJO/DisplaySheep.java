package com.sheepdivide.master.dataLayer.POJO;

public class DisplaySheep {
    private String sheepId, typeOfSheep, note, fieldName, username;
    private int weightKg, wool, horns, legs, sheepPoints;

    public DisplaySheep() {
    }

    public DisplaySheep(String sheepId, String typeOfSheep, String note, String fieldName, String username, int weightKg, int wool, int horns, int legs, int sheepPoints) {
        this.sheepId = sheepId;
        this.typeOfSheep = typeOfSheep;
        this.note = note;
        this.fieldName = fieldName;
        this.username = username;
        this.weightKg = weightKg;
        this.wool = wool;
        this.horns = horns;
        this.legs = legs;
        this.sheepPoints = sheepPoints;
    }

    public String getSheepId() {
        return sheepId;
    }

    public void setSheepId(String sheepId) {
        this.sheepId = sheepId;
    }

    public String getTypeOfSheep() {
        return typeOfSheep;
    }

    public void setTypeOfSheep(String typeOfSheep) {
        this.typeOfSheep = typeOfSheep;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public int getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(int weightKg) {
        this.weightKg = weightKg;
    }

    public int getWool() {
        return wool;
    }

    public void setWool(int wool) {
        this.wool = wool;
    }

    public int getHorns() {
        return horns;
    }

    public void setHorns(int horns) {
        this.horns = horns;
    }

    public int getLegs() {
        return legs;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getSheepPoints() {
        return sheepPoints;
    }

    public void setSheepPoints(int sheepPoints) {
        this.sheepPoints = sheepPoints;
    }
}
