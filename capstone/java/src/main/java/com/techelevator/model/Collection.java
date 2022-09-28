package com.techelevator.model;

public class Collection {

    long collectionId;
    String collectionName;
    long userId;
    boolean isPublic;

    public Collection(long collectionId, String collectionName, long userId, boolean isPublic) {
        this.collectionId = collectionId;
        this.collectionName = collectionName;
        this.userId = userId;
        this.isPublic = isPublic;
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

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }

    @Override
    public String toString() {
        return "Collection{" +
                "collectionId=" + collectionId +
                ", collectionName='" + collectionName + '\'' +
                ", userId=" + userId +
                ", isPublic=" + isPublic +
                '}';
    }
}
