package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.myapplication.fragments.BasketFragment;
import com.example.myapplication.fragments.CompareFragment;
import com.example.myapplication.fragments.FavFragment;
import com.example.myapplication.fragments.MainFragment;
import com.example.myapplication.fragments.SearchFragment;

public class MyPagerAdapter extends FragmentPagerAdapter {
    private int numOfTabs;
    public MyPagerAdapter(@NonNull FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs=numOfTabs;
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new MainFragment();
            case 1:
                return new CompareFragment();
            case 2:
                return new SearchFragment();
            case 3:
                return new BasketFragment();
            case 4:
                return new FavFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
