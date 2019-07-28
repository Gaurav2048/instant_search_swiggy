package com.example.instant_search.Model.Resto;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("rating")
    @Expose
    private String rating;
    @SerializedName("cousines")
    @Expose
    private String cousines;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("discount")
    @Expose
    private String discount;

    /**
     * No args constructor for use in serialization
     *
     */
    public Datum() {
    }

    /**
     *
     * @param id
     * @param cousines
     * @param name
     * @param image
     * @param rating
     * @param discount
     */
    public Datum(String name, String image, String rating, String cousines, String id, String discount) {
        super();
        this.name = name;
        this.image = image;
        this.rating = rating;
        this.cousines = cousines;
        this.id = id;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getCousines() {
        return cousines;
    }

    public void setCousines(String cousines) {
        this.cousines = cousines;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

}