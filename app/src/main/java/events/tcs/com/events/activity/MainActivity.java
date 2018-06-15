package events.tcs.com.events.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import events.tcs.com.events.R;
import events.tcs.com.events.constant.ApplicationData;
import events.tcs.com.events.data.CarRecyclerViewItem;
import events.tcs.com.events.fragment.DayOneFragment;
import events.tcs.com.events.fragment.DayThreeFragment;
import events.tcs.com.events.fragment.DayTwoFragment;
import events.tcs.com.events.fragment.KeyStakeholders;
import events.tcs.com.events.utils.SharedPreferencesManager;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
public ImageView img1;
    CarouselView carouselView;
    int[] sampleImages = {R.drawable.ic_kol_hayaat,R.drawable.carousel_1,R.drawable.carousel_howrahbridge,R.drawable.carousel_2,R.drawable.carousel_3, R.drawable.ic_kol_eden,R.drawable.carousel_5};
    private int selectedId = 0;
    private Activity mActivity;
    private FragmentManager mFragmentManager;
    private View viewHome;
    private FrameLayout viewDays;
    private TextView textViewWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mActivity = this;
        initView();
    }

    private void initView() {
        String user = SharedPreferencesManager.readSharedPref(mActivity, ApplicationData.USER_KEY);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        carouselView = (CarouselView) findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(imageListener);
        viewHome = findViewById(R.id.layout_home);
        viewDays = findViewById(R.id.layout_main);
        textViewWelcome = (TextView) findViewById(R.id.tv_welcomeUser);
        if (user != "")
            textViewWelcome.setText("Hi, " + user);
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (selectedId != 0) {
                toggleHome(true);
                selectedId = 0;
            } else {
                super.onBackPressed();
            }
        }
    }

    private void toggleHome(boolean showHome) {
        if (showHome) {
            viewHome.setVisibility(View.VISIBLE);
            viewDays.setVisibility(View.GONE);
        } else {
            viewHome.setVisibility(View.GONE);
            viewDays.setVisibility(View.VISIBLE);
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        selectedId = item.getItemId();
        mFragmentManager = getSupportFragmentManager();
        if (selectedId == R.id.nav_dayOne) {
            FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
            xfragmentTransaction.replace(R.id.layout_main, new DayOneFragment()).commit();
            toggleHome(false);
        } else if (selectedId == R.id.nav_dayTwo) {
            FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
            xfragmentTransaction.replace(R.id.layout_main, new DayTwoFragment()).commit();
            toggleHome(false);
        } else if (selectedId == R.id.nav_dayThree) {
            FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
            xfragmentTransaction.replace(R.id.layout_main, new DayThreeFragment()).commit();
            toggleHome(false);
        }
        else if (selectedId == R.id.nav_key) {
            FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
            xfragmentTransaction.replace(R.id.layout_main, new KeyStakeholders()).commit();
            toggleHome(false);
        }else {
            toggleHome(true);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void image_click(View view)
    {
        img1=(ImageView) findViewById(R.id.imageView);
        Intent intent1 =new Intent(this,MainActivity.class);
        startActivity(intent1);
    }

   /* public void opennavdrawer(View v){
        DrawerLayout drawer1 = (DrawerLayout) findViewById(R.id.drawer_layout);
        TextView textview1 = (TextView) findViewById(R.id.textView3);
        ActionBarDrawerToggle toggle1 = new ActionBarDrawerToggle(
                this, drawer1, textView3, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer1.setDrawerListener(toggle1);
        toggle1.syncState();
    }*/
}
