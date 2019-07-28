package com.example.instant_search.Model.Resto;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class restaurants {

    @SerializedName("code")
    @Expose
    private int code;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;
    @SerializedName("phrase")
    @Expose
    private String phrase;

    /**
     * No args constructor for use in serialization
     *
     */
    public restaurants() {
    }

    /**
     *
     * @param phrase
     * @param data
     * @param code
     */
    public restaurants(int code, List<Datum> data, String phrase) {
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

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

}