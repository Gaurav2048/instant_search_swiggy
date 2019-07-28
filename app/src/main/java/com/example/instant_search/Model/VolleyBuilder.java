package com.example.instant_search.Model;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

public class VolleyBuilder {

    public static VolleyBuilder instance;
    RequestQueue requestQueue;
    Context context;

    public VolleyBuilder(Context context) {
        this.context = context;
        requestQueue = Volley.newRequestQueue(context);
    }


    public static VolleyBuilder getInstance(Context context){
        if (instance == null){
            instance = new VolleyBuilder(context);
        }
        return instance;
    }

    public RequestQueue getRequestQue(){
        return requestQueue;
    }

}
