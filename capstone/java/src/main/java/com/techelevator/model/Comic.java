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
    Date coverDate;
    Date inStoreDate;
    String image;


    public Comic(long comicId, String title, String volume, int issueNumber, String genre, String author, Date coverDate, Date inStoreDate) {
        this.comicId = comicId;
        this.title = title;
        this.volume = volume;
        this.issueNumber = issueNumber;
        this.genre = genre;
        this.author = author;
        this.coverDate = coverDate;
        this.inStoreDate = inStoreDate;
    }

    public Comic(long comicId, String title, String volume, int issueNumber, Date coverDate, String image) {
        this.comicId = comicId;
        this.title = title;
        this.volume = volume;
        this.issueNumber = issueNumber;
        this.coverDate = coverDate;
        this.image = image;
    }

    public Comic() {
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

    public Date getCoverDate() {
        return coverDate;
    }

    public void setCoverDate(Date coverDate) {
        this.coverDate = coverDate;
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
                ", coverDate=" + coverDate +
                ", inStoreDate=" + inStoreDate +
                '}';
    }
}
