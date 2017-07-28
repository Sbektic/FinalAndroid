package com.example.zuco.finalandroid.Activity;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.example.zuco.finalandroid.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/*
RadioGroup to determine inge

 */


public class RadioGroupActivity extends BaseActivity {
    private int checkedID;
String sauce;
    @BindView(R.id.activity_radio_group)
    RadioGroup radioGroup;

    @OnClick(R.id.activity_radio_group_submit)
    public void submit(View view){
        shortToast("You will need:" + sauce);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_group);
        ButterKnife.bind(this);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId){
                checkedID = checkedId;
                if(checkedID==1){
                    sauce="flour,sugar,eggs, and water";
                 }if(checkedID==2){
                    sauce="flour, salt and water";
                  }
                    if(checkedID==3){
                        sauce="flour,sugar and water";

                     }
            }
        } );

    }
}
