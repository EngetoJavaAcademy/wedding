package com.engeto.wedding.model;

import java.util.Date;

public class Occurrence {

    Date dateOfWedding;
    String title;
    Integer maximalPriceForGift;

    public Occurrence() {
    }

    public Occurrence(Date dateOfWedding, String title, Integer maximalPriceForGift) {
        dateOfWedding = dateOfWedding;
        title = title;
        this.maximalPriceForGift = maximalPriceForGift;
    }

    public Date getDateOfWedding() {
        return dateOfWedding;
    }

    public void setDateOfWedding(Date dateOfWedding) {
        dateOfWedding = dateOfWedding;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        title = title;
    }

    public Integer getMaximalPriceForGift() {
        return maximalPriceForGift;
    }

    public void setMaximalPriceForGift(Integer maximalPriceForGift) {
        this.maximalPriceForGift = maximalPriceForGift;
    }

    @Override
    public String toString() {
        return "Occurrence{" +
                "dateOfWedding=" + dateOfWedding +
                ", title='" + title + '\'' +
                ", maximalPriceForGift=" + maximalPriceForGift +
                '}';
    }
}
