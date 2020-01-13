package com.example.organicwala;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ListView;

import com.example.organicwala.abstractactivity.MyAbstractActivity;
import com.example.organicwala.activities.MainActivity;
import com.example.organicwala.adapters.MenuAdapter;
import com.example.organicwala.fragments.AboutUsFragment;
import com.example.organicwala.fragments.AccountFragment;
import com.example.organicwala.fragments.ContactUsFragment;
import com.example.organicwala.fragments.FavouritesFragment;
import com.example.organicwala.fragments.HomeFragment;
import com.example.organicwala.fragments.MyOrderFragment;
import com.example.organicwala.fragments.NotificationFragment;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateManagerFactory;
import com.google.android.play.core.install.InstallState;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import com.google.android.play.core.install.model.AppUpdateType;
import com.google.android.play.core.install.model.InstallStatus;
import com.google.android.play.core.install.model.UpdateAvailability;

public class HomeActivity extends MyAbstractActivity {
    @BindView(R.id.toolbar_main)
    Toolbar toolbar;
    @BindView(R.id.drawer)
    DrawerLayout drawer;
    @BindView(R.id.nav_view)
    NavigationView nav_view;
    private ActionBarDrawerToggle mAppBarConfiguration;
    String titles[] = {"Home", "About Us", "Profile", "My Order", "My Favourites", "Notification", "Contact Us"};
    private AppUpdateManager mAppUpdateManager;
    private String TAG = "HomeActivity";
    private int RC_APP_UPDATE = 869;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       initview();
       updateApp();
    }

    private void showFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.placeholder, fragment).commit();
    }


    private void updateApp() {

        mAppUpdateManager = AppUpdateManagerFactory.create(this);

        mAppUpdateManager.registerListener(installStateUpdatedListener);

        mAppUpdateManager.getAppUpdateInfo().addOnSuccessListener(appUpdateInfo -> {

            if (appUpdateInfo.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE
                    && appUpdateInfo.isUpdateTypeAllowed(AppUpdateType.FLEXIBLE)) {

                try {
                    mAppUpdateManager.startUpdateFlowForResult(
                            appUpdateInfo, AppUpdateType.FLEXIBLE, HomeActivity.this, RC_APP_UPDATE);
                } catch (IntentSender.SendIntentException e) {
                    e.printStackTrace();
                }

            } else if (appUpdateInfo.installStatus() == InstallStatus.DOWNLOADED) {
                popupSnackbarForCompleteUpdate();
            } else {
                Log.e(TAG, "checkForAppUpdateAvailability: something else");
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_APP_UPDATE) {
            if (resultCode != RESULT_OK) {
                Log.e(TAG, "onActivityResult: app download failed");
            }
        }
    }


    InstallStateUpdatedListener installStateUpdatedListener = new
            InstallStateUpdatedListener() {
                @Override
                public void onStateUpdate(InstallState state) {
                    if (state.installStatus() == InstallStatus.DOWNLOADED) {
                        popupSnackbarForCompleteUpdate();
                    } else if (state.installStatus() == InstallStatus.INSTALLED) {
                        if (mAppUpdateManager != null) {
                            mAppUpdateManager.unregisterListener(installStateUpdatedListener);
                        }

                    } else {
                        Log.i(TAG, "InstallStateUpdatedListener: state: " + state.installStatus());
                    }
                }
            };


    private void popupSnackbarForCompleteUpdate() {

        Snackbar snackbar =
                Snackbar.make(
                        findViewById(R.id.coordinatorLayout_main),
                        "New app is ready!",
                        Snackbar.LENGTH_INDEFINITE);

        snackbar.setAction("Install", view -> {
            if (mAppUpdateManager != null) {
                mAppUpdateManager.completeUpdate();
            }
        });


        snackbar.setActionTextColor(getResources().getColor(R.color.colorPrimaryDark));
        snackbar.show();
    }

    @Override
    public void initview() {
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_menu);
        toolbar.setTitle("Home");
        mAppBarConfiguration = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.open, R.string.close);
        View view = nav_view.getRootView();
        ListView listView = view.findViewById(R.id.lv_menu);
        listView.setAdapter(new MenuAdapter(this));
        toolbar.setTitle(titles[0]);
        showFragment(new HomeFragment());

        listView.setOnItemClickListener((parent, view1, position, id) -> {
            toolbar.setTitle(titles[position]);
            switch (position) {
                case 0:
                    showFragment(new HomeFragment());
                    break;
                case 1:
                    showFragment(new AboutUsFragment());
                    break;
                case 2:
                    showFragment(new AccountFragment());
                    break;
                case 3:
                    showFragment(new MyOrderFragment());
                    break;
                case 4:
                    showFragment(new FavouritesFragment());
                    break;
                case 5:
                    showFragment(new NotificationFragment());
                    break;
                case 6:
                    showFragment(new ContactUsFragment());
                    break;
            }
            drawer.closeDrawer(Gravity.LEFT);

        });
    }

    @Override
    public void listners() {

    }
}
