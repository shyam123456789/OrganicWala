package com.example.organicwala.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.organicwala.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FavouriteListAdapter extends RecyclerView.Adapter<FavouriteListAdapter.FViewHolder> {
    Context context;

    public FavouriteListAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public FViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.favourite_item, parent, false);
        return new FViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class FViewHolder extends RecyclerView.ViewHolder {
        public FViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
