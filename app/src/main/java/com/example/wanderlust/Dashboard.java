package com.example.wanderlust;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.wanderlust.HelperClass.HomeAdapter.CategoriesAdapter;
import com.example.wanderlust.HelperClass.HomeAdapter.CategoriesHelperClass;
import com.example.wanderlust.HelperClass.HomeAdapter.FeaturedHelperClass;
import com.example.wanderlust.HelperClass.HomeAdapter.FeaturedAdapter;
import com.example.wanderlust.HelperClass.HomeAdapter.MostViewedAdapter;
import com.example.wanderlust.HelperClass.HomeAdapter.MostViewedHelperClass;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class Dashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    RecyclerView featuredRecycler;
    RecyclerView.Adapter adapter;
    RecyclerView mostViewedRecycler;
    RecyclerView categoriesrecycler;
    static final float END_SCALE = 0.7f;
    LinearLayout contentView;

    NavigationView navigationView;
    DrawerLayout drawerLayout;
    ImageView navMenuicon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dashboard);

        //Hooks
        featuredRecycler = findViewById(R.id.featured_recycler);
        mostViewedRecycler = findViewById(R.id.most_view_recycler);
        categoriesrecycler = findViewById(R.id.category_recycler);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navMenuicon = findViewById(R.id.nav_menu_icon);
        contentView = findViewById(R.id.contentView);


        
        NavigatioDrawer();

        featuredRecycler();
        mostViewedRecycler();
        categoriesrecycler();
    }

    private void NavigatioDrawer() {

        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener( this);
        navigationView.setCheckedItem(R.id.nav_home);

        navMenuicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START))
                {
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                else drawerLayout.openDrawer(GravityCompat.START);
            }
        });


        animateNaavigationDrawer();
    }

    private void animateNaavigationDrawer() {

        drawerLayout.setScrimColor(getResources().getColor(R.color.grad1));

        //Add any color or remove it to use the default one!
        //To make it transparent use Color.Transparent in side setScrimColor();
        //drawerLayout.setScrimColor(Color.TRANSPARENT);
        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

                // Scale the View based on current slide offset
                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);

                // Translate the View, accounting for the scaled width
                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentView.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView.setTranslationX(xTranslation);
            }
        });

    }

    @Override
    public void onBackPressed() {

        if(drawerLayout.isDrawerVisible(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START);
        else
            super.onBackPressed();
    }

    private void categoriesrecycler() {

        categoriesrecycler.setHasFixedSize(true);
        categoriesrecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        ArrayList<CategoriesHelperClass> categoriesLocations = new ArrayList<>();
        categoriesLocations.add(new CategoriesHelperClass(R.drawable.image_1,"Valley"));
        categoriesLocations.add(new CategoriesHelperClass(R.drawable.img,"efqw"));

        adapter = new CategoriesAdapter(categoriesLocations);
        categoriesrecycler.setAdapter(adapter);

    }

    private void mostViewedRecycler() {

        mostViewedRecycler.setHasFixedSize(true);
        mostViewedRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        ArrayList<MostViewedHelperClass> mostViewedlocations = new ArrayList<>();
        mostViewedlocations.add(new MostViewedHelperClass(R.drawable.image_1,"Valley","lksdh dihfos djhfkls fjkhdl sjkhf "));
        mostViewedlocations.add(new MostViewedHelperClass(R.drawable.img,"efqw","lksdh dihfos djhfkls fjkhdl sjkhf "));

        adapter = new MostViewedAdapter(mostViewedlocations);
        mostViewedRecycler.setAdapter(adapter);

    }

    private void featuredRecycler() {

        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        ArrayList<FeaturedHelperClass> featuredlocations = new ArrayList<>();
        featuredlocations.add(new FeaturedHelperClass(R.drawable.image_1,"Valley","lksdh dihfos djhfkls fjkhdl sjkhf "));
        featuredlocations.add(new FeaturedHelperClass(R.drawable.img,"efqw","lksdh dihfos djhfkls fjkhdl sjkhf "));

        adapter = new FeaturedAdapter(featuredlocations);
        featuredRecycler.setAdapter(adapter);


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return true;
    }
}