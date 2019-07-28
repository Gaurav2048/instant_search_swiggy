package com.example.instant_search.View.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.instant_search.Model.HistoryInterface;
import com.example.instant_search.R;

import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.viewHolder> {
    ArrayList<String> hsitory = new ArrayList<>();
    HistoryInterface historyInterface;
    public HistoryAdapter(@NonNull Context context, HistoryInterface historyInterface) {
        this.historyInterface = historyInterface;
        hsitory.add("chicken");
        hsitory.add("paneer");
        hsitory.add("Mutton");
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new viewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.unit_history, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder viewHolder, int i) {
        viewHolder.search.setText(hsitory.get(i));
    }

    @Override
    public int getItemCount() {
        return hsitory.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView search;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            search = itemView.findViewById(R.id.history);
            search.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            historyInterface.getHistory(hsitory.get(getAdapterPosition()));
        }
    }

}
