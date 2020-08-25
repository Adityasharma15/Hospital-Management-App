package com.example.parthvaishnavi.project;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.parthvaishnavi.project.fragments.gal1;
import com.example.parthvaishnavi.project.fragments.gal2;
import com.example.parthvaishnavi.project.fragments.gal3;
import com.example.parthvaishnavi.project.fragments.gal4;
import com.example.parthvaishnavi.project.fragments.gal5;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anant Kedia on 13-07-2018.
 */

public class Gallery extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery);

        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(gal1.newInstance());
        fragments.add(gal2.newInstance());
        fragments.add(gal3.newInstance());
        fragments.add(gal4.newInstance());
        fragments.add(gal5.newInstance());

        CustomPageAdapter customPagerAdapter = new CustomPageAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(customPagerAdapter);
    }

    class CustomPageAdapter extends FragmentStatePagerAdapter {
        List<Fragment> fragments;

        public CustomPageAdapter(FragmentManager fm, List<Fragment> frags) {
            super(fm);
            fragments = frags;
        }

        @Override
        public Fragment getItem(int position) {
            int index = position % fragments.size();
            return fragments.get(index);
        }

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }
    }
}
