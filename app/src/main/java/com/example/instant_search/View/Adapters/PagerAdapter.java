package com.example.instant_search.View.Adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.instant_search.View.Fragments.FoodFragment;
import com.example.instant_search.View.Fragments.RestaurantFragment;

public class PagerAdapter extends FragmentPagerAdapter {
    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        if(i==0){
            return new FoodFragment();
        }else if(i==1){
            return new RestaurantFragment();
        }
        return null;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position==0){
            return "Dishes";
        }else if(position ==1){
            return "Restaurants";
        }
        return " " ;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
