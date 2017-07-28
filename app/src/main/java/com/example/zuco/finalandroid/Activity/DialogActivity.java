package com.example.zuco.finalandroid.Activity;

import android.content.DialogInterface;
import android.support.annotation.IdRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.example.zuco.finalandroid.R;
import com.example.zuco.finalandroid.dialog.CustomDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DialogActivity extends BaseActivity {
    private int checkedID= 0;
   @BindView(R.id.activity_dialog_rdg)
    RadioGroup radioGroup;
    @OnClick(R.id.activity_dialog_ok)
    public void ok(View v){
        switch(checkedID){

            case R.id.activity_dialog_rb8:
              CustomDialog customDialog =
                        new CustomDialog(this, new CustomDialog.ICustomDialogListener() {
                            @Override
                            public void onOKClicked(String msg) {
                                shortToast(msg);
                            }

                            @Override
                            public void onCancelClicked() {

                            }
                        });
                customDialog.setCanceledOnTouchOutside(true);
                customDialog.show();
                shortToast("You chose the last one ");
                break;
            default:

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        ButterKnife.bind(this);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId){
                shortToast("You chose: "+ checkedId);
                checkedID = checkedId;
            }
        } );
    }
    private void normalDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("AlertTitle");
        builder.setMessage("This is a normal Dialog");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which){
                shortToast("You clicked yes");
            }
        });
        builder.setNeutralButton("Neutral", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which){
                shortToast("You clicked neutral");
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which){
                shortToast("You clicked Cancel");
            }
        });
        builder.show();
    }

    private void listDialog() {
        final String[] items = {"item1", "item2", "item3", "item4"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("I'm a List Dialog");
        builder.setIcon(R.mipmap.ic_launcher);
      //  builder.setItems(items, new DialogInterface.OnClickListener() {
         //   shortToast("You clicked: "+items[which]);
        //});
        builder.show();
    }
        }