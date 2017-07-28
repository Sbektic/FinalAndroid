package com.example.zuco.finalandroid.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.example.zuco.finalandroid.R;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/*
Checkbox used to determine final price when multiple items are used.
 */


public class CheckBoxActivity extends BaseActivity {

String post="1";
int cost=0;

    private HashMap<String,Boolean> list = new HashMap<String,Boolean>();

    @BindView(R.id.activity_check_box_1)
    CheckBox checkBox1;


    @BindView(R.id.activity_check_box_2)
    CheckBox checkBox2;

    @BindView(R.id.activity_check_box_3)
    CheckBox checkBox3;

    @OnClick(R.id.activity_check_box_submit)
    public void submit(View view){
        String s = "You checked: ";
        for(Map.Entry<String,Boolean> entry: list.entrySet()){
if(checkBox1.isChecked())
{                cost+=5;

   }
            if(checkBox2.isChecked())
            {                cost+=2;

            }

            if(checkBox3.isChecked())
            {                cost+=1;

            }

             if(entry.getValue()){
                s=s+" "+entry.getKey();


            }






        }
         longToast("Total: $"+ cost+ ".00");
        cost=0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);
        ButterKnife.bind(this);
        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                list.put(buttonView.getText().toString(), isChecked);
                post+="1ndchecked";
              //  cost+=10;

            }
        });
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                list.put(buttonView.getText().toString(), isChecked);
                post+="2ndchecked";
             //   cost+=2;
            }
        });
        checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                list.put(buttonView.getText().toString(), isChecked);
                post+="3ndchecked";
              //  cost+=1;

            }
        });
    }




}
