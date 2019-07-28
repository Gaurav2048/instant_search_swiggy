package com.example.instant_search.View.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.example.instant_search.Controller.SearchController;
import com.example.instant_search.Model.Resto.restaurants;
import com.example.instant_search.Model.SearchInterface;
import com.example.instant_search.Model.suggestionItemClick;
import com.example.instant_search.Model.suggestions.Suggestion;
import com.example.instant_search.R;
import com.example.instant_search.View.Adapters.FoodAdapter;
import com.example.instant_search.View.Adapters.SuggestionAdapter;
import com.example.instant_search.View.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoodFragment extends Fragment  implements SearchInterface , suggestionItemClick {

    RecyclerView recyclerFoodResult;
    SearchController searchController;
    String phrase;
    public FoodFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_food, container, false);
        searchController = new SearchController(getContext(), this);
        recyclerFoodResult = view.findViewById(R.id.recyclerFoodResult);
        recyclerFoodResult.setLayoutManager(new LinearLayoutManager(getContext()));
        searchController.getSugestions(phrase);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        phrase = ((MainActivity)getActivity()).getSearchPhrase();

    }

    @Override
    public void onStartOperations() {
        recyclerFoodResult.setVisibility(View.GONE);
    }

    @Override
    public void onGetSuggestions(Suggestion suggestion) {
        if(phrase != null && suggestion != null)
        {
            if(suggestion.getPhrase().equals(phrase)){
                recyclerFoodResult.setVisibility(View.VISIBLE);
                recyclerFoodResult.setAdapter(new SuggestionAdapter(getContext(), suggestion.getData(), this));
            }
        }
    }

    @Override
    public void onGetResults(restaurants result) {
        recyclerFoodResult.setVisibility(View.VISIBLE);
        recyclerFoodResult.setAdapter(new FoodAdapter(getContext(), result.getData()));
    }

    @Override
    public void onError(VolleyError error) {


    }

    @Override
    public void getSelectedSuggestions(String phrase) {
        searchController.Restaurant_search_by_food(phrase);
    }
}
