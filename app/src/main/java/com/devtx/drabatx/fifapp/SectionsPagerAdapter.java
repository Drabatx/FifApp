package com.devtx.drabatx.fifapp;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Jose Luis on 21/10/2016.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter{
    ArrayList<Fragment> arrayList = new ArrayList<>();
    ArrayList<String> arraytitles = new ArrayList<>();
    Activity activity;
    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
        this.activity =activity;
    }

    public void addFragment (Fragment fragment, String titles){
        this.arrayList.add(fragment);
        this.arraytitles.add(titles);

    }
    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        //activity.setTitle(arraytitles.get(position));
        return arrayList.get(position);
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return arrayList.size();
    }


    @Override
    public CharSequence getPageTitle(int position) {

        return arraytitles.get(position);
    }
}
