package com.example.instant_search.Model.suggestions;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Suggestion {

    @SerializedName("code")
    @Expose
    private int code;
    @SerializedName("data")
    @Expose
    private List<unit_suggestion> data = null;
    @SerializedName("phrase")
    @Expose
    private String phrase;

    /**
     * No args constructor for use in serialization
     *
     */
    public Suggestion() {
    }

    /**
     *
     * @param phrase
     * @param data
     * @param code
     */
    public Suggestion(int code, List<unit_suggestion> data, String phrase) {
        super();
        this.code = code;
        this.data = data;
        this.phrase = phrase;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<unit_suggestion> getData() {
        return data;
    }

    public void setData(List<unit_suggestion> data) {
        this.data = data;
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

}