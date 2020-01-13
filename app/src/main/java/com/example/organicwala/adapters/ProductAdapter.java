package com.example.organicwala.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.example.organicwala.R;

import androidx.annotation.NonNull;
import androidx.palette.graphics.Palette;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MHolder> {

    Context context;

    public ProductAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.products_item, parent, false);
        return new MHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MHolder holder, int position) {
        switch (position) {
            case 0:
                Glide.with(context).load(R.drawable.red).into(holder.menu_img);
                Bitmap myBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.red);
                if (myBitmap != null && !myBitmap.isRecycled()) {
                    Palette palette = Palette.from(myBitmap).generate();

                }
                break;

            case 1:
                Glide.with(context).load(R.drawable.blue).into(holder.menu_img);
                Bitmap myBitmap2 = BitmapFactory.decodeResource(context.getResources(), R.drawable.blue);
                if (myBitmap2 != null && !myBitmap2.isRecycled()) {
                    Palette palette = Palette.from(myBitmap2).generate();

                }
                break;

            case 2:
                Glide.with(context).load(R.drawable.orange).into(holder.menu_img);
                Bitmap myBitmap3 = BitmapFactory.decodeResource(context.getResources(), R.drawable.orange);
                if (myBitmap3 != null && !myBitmap3.isRecycled()) {
                    Palette palette = Palette.from(myBitmap3).generate();

                }
                break;

            case 3:
                Glide.with(context).load(R.drawable.yellow).into(holder.menu_img);
                Bitmap myBitmap4 = BitmapFactory.decodeResource(context.getResources(), R.drawable.yellow);
                if (myBitmap4 != null && !myBitmap4.isRecycled()) {
                    Palette palette = Palette.from(myBitmap4).generate();

                }
                break;


        }

    }

    @Override
    public int getItemCount() {
        return 4;
    }

    class MHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.menu_img)
        ImageView menu_img;

        @BindView(R.id.root)
        LinearLayout root;

        public MHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
