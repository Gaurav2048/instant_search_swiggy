package com.example.instant_search.Controller;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.instant_search.Model.Constant;
import com.example.instant_search.Model.Resto.restaurants;
import com.example.instant_search.Model.SearchInterface;
import com.example.instant_search.Model.VolleyBuilder;
import com.example.instant_search.Model.suggestions.Suggestion;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class SearchController {

    Context context;
    RequestQueue requestQueue;
    SearchInterface searchInterface;

    public SearchController(Context context, SearchInterface searchInterface) {
        this.context = context;
        this.searchInterface = searchInterface;
        requestQueue = VolleyBuilder.getInstance(context).getRequestQue();
    }

    public void getSugestions(final String phrase){
        searchInterface.onStartOperations();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Constant.SUGGESTION_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e( "onResponse: ",response );
              try
              {
                  Type listType = new TypeToken<Suggestion>(){}.getType();
                  Suggestion suggestion = new Gson().fromJson(response, listType);
                  searchInterface.onGetSuggestions(suggestion);

              }catch (Exception e){
                    searchInterface.onError(null);
              }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
              //  Log.e( "onErrorResponse: ",error.getMessage() );
                searchInterface.onError(error);
            }
        }){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> hasmap = new HashMap<>();
                hasmap.put("qry", phrase);
                return hasmap ;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> hasmap = new HashMap<>();
                hasmap.put("api_key", Constant.TOKEN);
                return hasmap;
            }
        };

        requestQueue.add(stringRequest);

    }

    public void Restaurant_search_by_food(final String phrase){
        searchInterface.onStartOperations();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Constant.RESTAURANT_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e( "onResponse: ",response );
                try
                {
                    Type listType = new TypeToken<restaurants>(){}.getType();
                    restaurants restaurant = new Gson().fromJson(response, listType);
                    searchInterface.onGetResults(restaurant);

                }catch (Exception e){
                    searchInterface.onError(null);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
               // Log.e( "onErrorResponse: ",error.getMessage() );
                searchInterface.onError(error);
            }
        }){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> hasmap = new HashMap<>();
                hasmap.put("qry", phrase);
                hasmap.put("domain", "food");
                return hasmap ;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> hasmap = new HashMap<>();
                hasmap.put("api_key", Constant.TOKEN);
                return hasmap;
            }
        };

        requestQueue.add(stringRequest);

    }

    public void Restaurant_search_by_restaurant(final String phrase){
        searchInterface.onStartOperations();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Constant.RESTAURANT_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e( "onResponse: ",response );
                try
                {
                    Type listType = new TypeToken<restaurants>(){}.getType();
                    restaurants restaurant = new Gson().fromJson(response, listType);
                    searchInterface.onGetResults(restaurant);

                }catch (Exception e){
                    searchInterface.onError(null);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
              //  Log.e( "onErrorResponse: ",error.getMessage() );
                searchInterface.onError(error);
            }
        }){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> hasmap = new HashMap<>();
                hasmap.put("qry", phrase);
                hasmap.put("domain", "restaurant");
                return hasmap ;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> hasmap = new HashMap<>();
                hasmap.put("api_key", Constant.TOKEN);
                return hasmap;
            }
        };

        requestQueue.add(stringRequest);

    }


}
