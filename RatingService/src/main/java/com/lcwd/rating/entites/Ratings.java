package com.lcwd.rating.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_ratings")
public class Ratings {
    @Id
    private String ratingsId;
    private String userId;
    private String hotelId;
    private int rating;
    private String feedback;

    public String getRatingsId() {
        return ratingsId;
    }

    public void setRatingsId(String ratingsId) {
        this.ratingsId = ratingsId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Ratings() {
    }

    public Ratings(String ratingsId, String userId, String hotelId, int rating, String feedback) {
        this.ratingsId = ratingsId;
        this.userId = userId;
        this.hotelId = hotelId;
        this.rating = rating;
        this.feedback = feedback;
    }
}
