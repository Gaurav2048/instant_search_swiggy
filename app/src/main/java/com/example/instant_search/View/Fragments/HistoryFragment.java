package com.example.instant_search.View.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.instant_search.Model.HistoryInterface;
import com.example.instant_search.Model.ItemClicked;
import com.example.instant_search.R;
import com.example.instant_search.View.Adapters.HistoryAdapter;
import com.example.instant_search.View.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryFragment extends Fragment implements HistoryInterface {

    ItemClicked itemClickedInterface;

    RecyclerView HistoryRecyclerView;
    public HistoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=  inflater.inflate(R.layout.fragment_history, container, false);
        HistoryRecyclerView = view.findViewById(R.id.HistoryRecyclerView);
        HistoryRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        HistoryRecyclerView.setAdapter(new HistoryAdapter(getContext(), this));

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        itemClickedInterface = (ItemClicked) getContext();
    }

    @Override
    public void getHistory(String phrase) {
        itemClickedInterface.onClickedPosition(phrase);
    }
}
