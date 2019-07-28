package com.example.instant_search.View.Fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.instant_search.R;
import com.example.instant_search.View.Adapters.PagerAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {

    TabLayout tablayout;
    ViewPager viewPager;

    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_search, container, false);
        tablayout = view.findViewById(R.id.tablayout);
        viewPager = view.findViewById(R.id.viewPager);

        viewPager.setAdapter(new PagerAdapter(getChildFragmentManager()));
        tablayout.setupWithViewPager(viewPager);

        return view;
    }

}
