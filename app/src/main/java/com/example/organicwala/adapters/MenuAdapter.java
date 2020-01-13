package com.example.organicwala.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.bumptech.glide.Glide;
import com.example.organicwala.R;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;

public class MenuAdapter extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    String titles[] = {"Home", "About Us", "Profile", "My Order", "My Favourites", "Delivery Address", "Share", "Privacy Policy", "Terms and Conditions", "Notification", "Contact Us"};
    int icons[] = {R.drawable.ic_home,
            R.drawable.ic_info,
            R.drawable.ic_account,
            R.drawable.ic_shopping_cart,
            R.drawable.ic_favorite,
            R.drawable.ic_location,
            R.drawable.ic_share,
            R.drawable.ic_policy,
            R.drawable.ic_terms_and_conditions,
            R.drawable.ic_notification,
            R.drawable.ic_call};

    public MenuAdapter(Context context) {
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return 11;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.raw_item, parent, false);

        }
        AppCompatImageView icon = convertView.findViewById(R.id.iv_icon);
        AppCompatTextView title = convertView.findViewById(R.id.tv_title);
        Glide.with(context).load(context.getResources().getDrawable(icons[position])).into(icon);
        title.setText(titles[position]);
        return convertView;
    }
}
