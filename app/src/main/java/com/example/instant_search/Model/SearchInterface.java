package com.example.instant_search.Model;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.example.instant_search.Model.Resto.restaurants;
import com.example.instant_search.Model.suggestions.Suggestion;

public interface SearchInterface {

    void onStartOperations();
    void onGetSuggestions(Suggestion suggestion);
    void onGetResults(restaurants result);
    void onError(VolleyError error);

}
