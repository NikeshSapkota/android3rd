package com.online_clothing;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ViewPagerActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        tabLayout = findViewById(R.id.tabid);
        viewPager = findViewById(R.id.viewpager);

        pagerAdapter adapter = new pagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new SignFragment(), "Register");
        adapter.addFragment(new LogFragment(), "Login");


        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
