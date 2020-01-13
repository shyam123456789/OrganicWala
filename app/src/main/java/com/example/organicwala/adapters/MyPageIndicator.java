package com.example.organicwala.adapters;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

import com.example.organicwala.R;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

public class MyPageIndicator extends LinearLayout {
    private int mPageCount;
    private int activeColor, nonActiveColor;
    private int height, width, margin;

    Drawable active, nonActive;

    LayoutParams params;

    public MyPageIndicator(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.PageIndicatorView);
        mPageCount = a.getInt(R.styleable.PageIndicatorView_piv_count, 0);
        activeColor = a.getColor(R.styleable.PageIndicatorView_piv_activeColor, Color.BLUE);
        nonActiveColor = a.getColor(R.styleable.PageIndicatorView_piv_nonActiveColor, Color.GRAY);
        width = a.getDimensionPixelSize(R.styleable.PageIndicatorView_piv_width, 15);
        height = a.getDimensionPixelSize(R.styleable.PageIndicatorView_piv_height, 15);
        margin = a.getDimensionPixelSize(R.styleable.PageIndicatorView_piv_spaceBetweenDot, 2);

        a.recycle();

        initView();


    }

    /*init the view and add views to linearlayout*/
    private void initView() {

        active =   ContextCompat.getDrawable(getContext(),R.drawable.active);
        nonActive =   ContextCompat.getDrawable(getContext(),R.drawable.nonactive);
        setGravity(Gravity.CENTER_HORIZONTAL);
        params = new LayoutParams(
                width,
                height
        );

        params.setMargins(margin, margin, margin, margin);
        if (mPageCount > 0)
            setIndicator(mPageCount);


    }


    //highlight the selected postion
    public void setSelectedPage(int position) {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt != null)
                childAt.setBackground(nonActive);
        }
        View selectedChild = getChildAt(position);
        if (selectedChild != null)
            selectedChild.setBackground(active);
    }


    //number of page to show
    public void setIndicator(int mPageCount) {
        this.mPageCount = mPageCount;
        for (int i = 0; i < mPageCount; i++) {
            View view = new View(getContext());
            view.setLayoutParams(params);
            if (i == 0)
                view.setBackground(active);
            else view.setBackground(nonActive);
            final int finalI = i;

            addView(view);

        }
    }


}
