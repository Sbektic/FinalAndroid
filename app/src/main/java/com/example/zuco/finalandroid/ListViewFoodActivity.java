package com.example.zuco.finalandroid;

import android.app.ListActivity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zuco.finalandroid.Activity.ViewPagerActivity;

import java.util.ArrayList;


/*
Listview diplay all recipes.


 */


public class ListViewFoodActivity extends AppCompatActivity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_food);


        String [] foods = {"Cake", "Bread", "Muffin"};

        ListAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,foods);
        ListView lv = (ListView) findViewById(R.id.recipe_list_view);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = ((TextView)view).getText().toString();
                Toast.makeText(getBaseContext(), item,Toast.LENGTH_LONG).show();
                Intent myIntent = new Intent( ListViewFoodActivity.this , ViewPagerActivity.class);
                startActivity(myIntent);
            }


        });
    }
}