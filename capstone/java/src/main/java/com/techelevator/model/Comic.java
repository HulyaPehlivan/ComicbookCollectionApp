package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Comic {

    int comicId;
    int collection_id;
    String title;
    String volume;
    int issueNumber;
    String releaseDate;
    String image;
    String iconURL;
    int apiID;
    String description;
    String publisher;
    int quantity;

    public Comic(String title, String releaseDate, String image, String iconURL, int apiID, String description, String publisher, int quantity) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.image = image;
        this.iconURL = iconURL;
        this.apiID = apiID;
        this.description = description;
        this.publisher = publisher;
        this.quantity = quantity;
    }

    public Comic(String title, String releaseDate, String image, int apiID, String description) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.image = image;
        this.apiID = apiID;
        this.description = description;
    }

    public Comic(String title, String releaseDate, String image, String iconURL, int apiID, String description, String publisher, String volume) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.image = image;
        this.iconURL = iconURL;
        this.apiID = apiID;
        this.description = description;
        this.publisher = publisher;
        this.volume = volume;
    }

    public Comic() {
    }

    public int getCollection_id() {
        return collection_id;
    }

    public void setCollection_id(int collection_id) {
        this.collection_id = collection_id;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getIconURL() {
        return iconURL;
    }

    public void setIconURL(String iconURL) {
        this.iconURL = iconURL;
    }

    public int getApiID() {
        return apiID;
    }

    public void setApiID(int apiID) {
        this.apiID = apiID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getComicId() {
        return comicId;
    }

    public void setComicId(int comicId) {
        this.comicId = comicId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Comic{" +
                "comicId=" + comicId +
                ", title='" + title + '\'' +
                ", issueNumber=" + issueNumber +
                ", coverDate=" + releaseDate +
                '}';
    }
}
