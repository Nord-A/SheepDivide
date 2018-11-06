package com.sheepdivide.master.dataLayer.POJO;

/*
POJO. Being used to get data from html into database
 */
public class Sheep {
    private String sheepId, sheepType, note;
    private int sheepWeight, sheepWool, sheepHorns, sheepLegs;

    public Sheep() {
    }

    public Sheep(String sheepId) {
        this.sheepId = sheepId;
    }

    public Sheep(String sheepId, String sheepType, String note, int sheepWeight, int sheepWool, int sheepHorns, int sheepLegs) {
        this.sheepId = sheepId;
        this.sheepType = sheepType;
        this.note = note;
        this.sheepWeight = sheepWeight;
        this.sheepWool = sheepWool;
        this.sheepHorns = sheepHorns;
        this.sheepLegs = sheepLegs;
    }

    public String getSheepId() {
        return sheepId;
    }

    public void setSheepId(String sheepId) {
        this.sheepId = sheepId;
    }

    public String getSheepType() {
        return sheepType;
    }

    public void setSheepType(String sheepType) {
        this.sheepType = sheepType;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getSheepWeight() {
        return sheepWeight;
    }

    public void setSheepWeight(int sheepWeight) {
        this.sheepWeight = sheepWeight;
    }

    public int getSheepWool() {
        return sheepWool;
    }

    public void setSheepWool(int sheepWool) {
        this.sheepWool = sheepWool;
    }

    public int getSheepHorns() {
        return sheepHorns;
    }

    public void setSheepHorns(int sheepHorns) {
        this.sheepHorns = sheepHorns;
    }

    public int getSheepLegs() {
        return sheepLegs;
    }

    public void setSheepLegs(int sheepLegs) {
        this.sheepLegs = sheepLegs;
    }
}
