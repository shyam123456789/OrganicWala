package com.example.organicwala.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.organicwala.R;

import java.util.Random;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.MViewHolder> {

    Context context;
    int colors[] = {R.color.colorrandom1, R.color.colorrandom2, R.color.colorrandom3};
    Random random;

    public NotificationAdapter(Context context) {
        this.context = context;
        random = new Random();
    }


    @NonNull
    @Override
    public MViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_item, parent, false);
        return new MViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MViewHolder holder, int position) {
        int i = random.nextInt(3);
        holder.ll_root.setBackgroundColor(context.getResources().getColor(colors[i]));

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class MViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.ll_root)
        LinearLayoutCompat ll_root;
        @BindView(R.id.tv_title)
        AppCompatTextView tv_title;
        @BindView(R.id.tv_des)
        AppCompatTextView tv_des;

        public MViewHolder(@NonNull View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }
}
