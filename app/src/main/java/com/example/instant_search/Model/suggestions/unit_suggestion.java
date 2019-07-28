package com.example.instant_search.Model.suggestions;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class unit_suggestion {

    @SerializedName("name")
    @Expose
    private String name;

    /**
     * No args constructor for use in serialization
     *
     */
    public unit_suggestion() {
    }

    /**
     *
     * @param name
     */
    public unit_suggestion(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}