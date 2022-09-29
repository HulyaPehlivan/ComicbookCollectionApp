package com.techelevator.model;

public class Collection {

    int collectionId;
    String collectionName;
    int userId;
    boolean isPublic;

    public Collection(int collectionId, String collectionName, int userId, boolean isPublic) {
        this.collectionId = collectionId;
        this.collectionName = collectionName;
        this.userId = userId;
        this.isPublic = isPublic;
    }

    public Collection() {
    }

    public int getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(int collectionId) {
        this.collectionId = collectionId;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
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
