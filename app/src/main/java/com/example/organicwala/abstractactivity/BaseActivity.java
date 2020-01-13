package com.example.organicwala.abstractactivity;


import android.app.ProgressDialog;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;


public class BaseActivity extends AppCompatActivity {

    public TextView tv_cart_size;
    View v;

    ProgressDialog dialog;



    private void iniDialog() {
        dialog = new ProgressDialog(this);

    }

    public ProgressDialog getDialog() {
        if (dialog == null)
            iniDialog();

        return dialog;

    }


    public void setToolbar(Toolbar toolbar) {
        setSupportActionBar(toolbar);
        //   getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void showBackButton() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //  getSupportActionBar().setHomeAsUpIndicator(R.drawable.vc_left_arrow);
    }

    public void setTitle(String title) {
        getSupportActionBar().setTitle(title);

    }

  /*
     * launch activity withous inent data
     * */
    public void launchActivity(Class classToLaunch) {
        startActivity(new Intent(this, classToLaunch));
        overridePendingTransition(android.R.anim.fade_in
                , android.R.anim.fade_out);
    }

    public void launchActivityforesult(Class classToLaunch,int requestcode) {
        startActivityForResult(new Intent(this, classToLaunch),requestcode);
        overridePendingTransition(android.R.anim.fade_in
                , android.R.anim.fade_out);
    }


    public void loadFragment(Fragment fragment, int containerId) {
        getSupportFragmentManager().beginTransaction().replace(containerId, fragment).commit();
    }

    public void loadFragment(Fragment fragment, int containerId, String stack) {
        getSupportFragmentManager().beginTransaction().replace(containerId, fragment).addToBackStack(stack).commit();

    }
}
