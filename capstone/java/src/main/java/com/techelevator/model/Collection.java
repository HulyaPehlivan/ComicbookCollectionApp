package com.techelevator.model;

public class Collection {

    long collectionId;
    String collectionName;
    long userId;
    boolean status;

    public Collection(long collectionId, String collectionName, long userId, boolean status) {
        this.collectionId = collectionId;
        this.collectionName = collectionName;
        this.userId = userId;
        this.status = status;
    }

    public Collection() {
    }

    public long getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(long collectionId) {
        this.collectionId = collectionId;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Collection{" +
                "collectionId=" + collectionId +
                ", collectionName='" + collectionName + '\'' +
                ", userId=" + userId +
                ", status=" + status +
                '}';
    }
}
