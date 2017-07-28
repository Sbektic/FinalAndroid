package com.example.zuco.finalandroid.Activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.zuco.finalandroid.Adapter.ViewPagerAdapter;
import com.example.zuco.finalandroid.Fragment.BreadFragment;
import com.example.zuco.finalandroid.Fragment.CakeFragment;
import com.example.zuco.finalandroid.Fragment.MuffinFragment;
import com.example.zuco.finalandroid.R;

import java.util.ArrayList;
import java.util.List;

/*Viewpager, fragments display picture of food item, ingredients needed and cooking time.

 */


public class ViewPagerActivity extends FragmentActivity {
      ViewPagerAdapter pageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        List<Fragment> fragments = getFragments();
        pageAdapter = new ViewPagerAdapter(getSupportFragmentManager(), fragments);
        ViewPager pager =
                (ViewPager)findViewById(R.id.viewpager);
        pager.setAdapter(pageAdapter);
    }

    public List<Fragment> getFragments() {
        List<Fragment> fList = new ArrayList<Fragment>();
        fList.add(BreadFragment.newInstance(""));
        fList.add(CakeFragment.newInstance(""));
        fList.add(MuffinFragment.newInstance(""));

        return fList;
    }
}

