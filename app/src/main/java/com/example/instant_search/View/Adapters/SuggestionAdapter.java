package com.example.instant_search.View.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.instant_search.Model.suggestionItemClick;
import com.example.instant_search.Model.suggestions.unit_suggestion;
import com.example.instant_search.R;

import java.util.List;

public class SuggestionAdapter extends RecyclerView.Adapter<SuggestionAdapter.viewHolder> {

    List<unit_suggestion> suggestionList;
    Context context;
    suggestionItemClick suggestionItemClick;

    public SuggestionAdapter(@NonNull Context context, List<unit_suggestion> suggestionList, suggestionItemClick suggestionItemClick) {
        this.context = context;
        this.suggestionList = suggestionList;
        this.suggestionItemClick = suggestionItemClick;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new viewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.unit_suggestion, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder viewHolder, int i) {
        viewHolder.search.setText(suggestionList.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return suggestionList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView search;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            search = itemView.findViewById(R.id.search);
            search.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(v==search){
                suggestionItemClick.getSelectedSuggestions(suggestionList.get(getAdapterPosition()).getName());
            }
        }
    }

}
