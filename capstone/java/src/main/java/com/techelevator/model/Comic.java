package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Comic {

    long comicId;
    String title;
    String volume;
    int issueNumber;
    String genre;
    String author;
    String releaseDate;
    Date inStoreDate;
    String image;
    String deck;
    String iconURL;
    int apiID;
    String description;
    String publisher;

    public Comic(String title, String releaseDate, String image, String deck, String iconURL, int apiID, String description, String publisher) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.image = image;
        this.deck = deck;
        this.iconURL = iconURL;
        this.apiID = apiID;
        this.description = description;
        this.publisher = publisher;
    }

    public Comic(String title, String releaseDate, String image, String deck, int apiID, String description) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.image = image;
        this.deck = deck;
        this.apiID = apiID;
        this.description = description;
    }

    public Comic(String title, String releaseDate, String image, String deck, String iconURL, int apiID, String description, String publisher, String volume) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.image = image;
        this.deck = deck;
        this.iconURL = iconURL;
        this.apiID = apiID;
        this.description = description;
        this.publisher = publisher;
        this.volume = volume;
    }

    public Comic() {
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDeck() {
        return deck;
    }

    public void setDeck(String deck) {
        this.deck = deck;
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

    public long getComicId() {
        return comicId;
    }

    public void setComicId(long comicId) {
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getInStoreDate() {
        return inStoreDate;
    }

    public void setInStoreDate(Date inStoreDate) {
        this.inStoreDate = inStoreDate;
    }

    @Override
    public String toString() {
        return "Comic{" +
                "comicId=" + comicId +
                ", title='" + title + '\'' +
                //", volume='" + volume + '\'' +
                ", issueNumber=" + issueNumber +
                ", genre='" + genre + '\'' +
                ", author='" + author + '\'' +
                ", coverDate=" + releaseDate +
                ", inStoreDate=" + inStoreDate +
                '}';
    }
}
