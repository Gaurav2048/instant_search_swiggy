package com.example.instant_search.View.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.instant_search.Model.Resto.Datum;
import com.example.instant_search.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.viewHolder> {
    List<Datum> suggestionList;
    Context context;
    public RestaurantAdapter(@NonNull Context context, List<Datum> suggestionList) {
        this.context = context;
        this.suggestionList = suggestionList;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new viewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.unit_restaurant, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder viewHolder, int i) {
        Datum datum = suggestionList.get(i);
        Picasso.get().load(datum.getImage()).into(viewHolder.imageView);
        viewHolder.name_restaurant.setText(datum.getName());
        viewHolder.rating.setText(datum.getRating());
        viewHolder.discount.setText(datum.getDiscount()+"% OFF");
    }

    @Override
    public int getItemCount() {
        return suggestionList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView name_restaurant;
        TextView dishes;
        TextView discount;
        TextView rating;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            name_restaurant = itemView.findViewById(R.id.name_restaurant);
            dishes = itemView.findViewById(R.id.dishes);
            discount = itemView.findViewById(R.id.discount);
            rating = itemView.findViewById(R.id.rating);

        }
    }

}
