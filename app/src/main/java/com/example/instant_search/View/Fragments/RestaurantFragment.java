package com.example.instant_search.View.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.example.instant_search.Controller.SearchController;
import com.example.instant_search.Model.Resto.restaurants;
import com.example.instant_search.Model.SearchInterface;
import com.example.instant_search.Model.suggestions.Suggestion;
import com.example.instant_search.R;
import com.example.instant_search.View.Adapters.RestaurantAdapter;
import com.example.instant_search.View.Adapters.SuggestionAdapter;
import com.example.instant_search.View.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantFragment extends Fragment implements SearchInterface {

    RecyclerView recyclerRestaurantResult;
    SearchController searchController;
    TextView noresult;
    String phrase;

    public RestaurantFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_restaurant, container, false);
        searchController = new SearchController(getContext(), this);
        noresult = view.findViewById(R.id.noresult);
        recyclerRestaurantResult = view.findViewById(R.id.recyclerRestaurantResult);
        recyclerRestaurantResult.setLayoutManager(new LinearLayoutManager(getContext()));
        searchController.Restaurant_search_by_restaurant(phrase);

        return  view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        phrase = ((MainActivity)getActivity()).getSearchPhrase();
    }

    @Override
    public void onStartOperations() {
        recyclerRestaurantResult.setVisibility(View.INVISIBLE);
        noresult.setVisibility(View.GONE);
    }

    @Override
    public void onGetSuggestions(Suggestion suggestion) {

    }

    @Override
    public void onGetResults(restaurants result) {
        if(result!= null){
            recyclerRestaurantResult.setVisibility(View.VISIBLE);
            if(result.getData().size()==0){
                noresult.setVisibility(View.VISIBLE);
                recyclerRestaurantResult.setVisibility(View.GONE);

            }else {
                recyclerRestaurantResult.setVisibility(View.VISIBLE);
                noresult.setVisibility(View.GONE);
                recyclerRestaurantResult.setAdapter(new RestaurantAdapter(getContext(), result.getData()));
            }

        }
    }

    @Override
    public void onError(VolleyError error) {

    }
}
