package com.example.zuco.finalandroid;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Matrix;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zuco.finalandroid.Activity.CheckBoxActivity;
import com.example.zuco.finalandroid.Activity.DialogActivity;
import com.example.zuco.finalandroid.Activity.HandlerActivity;
import com.example.zuco.finalandroid.Activity.RadioGroupActivity;
import com.example.zuco.finalandroid.Activity.ServiceActivity;
import com.example.zuco.finalandroid.Activity.ViewPagerActivity;

import java.util.ArrayList;



/*
Gesture, by double clicking on the cake picture the user will be able to zoom in and out.
Animation, on activity start falling android icon.
 */
public class MainActivity extends AppCompatActivity
        implements GestureDetector.OnGestureListener,GestureDetector.OnDoubleTapListener{
    Animation anim2;
    Button bib, pag,serv,rad,dialo,checkbox,hand;
    Button mOrder;
    TextView mItemSelected;
    String[] listItems;
    boolean[] checkedItems;
    ArrayList<Integer> Foods = new ArrayList<>();
    private ImageView iv;
    private Matrix matrix = new Matrix();
    private float scale = 1f;
    private ScaleGestureDetector SGD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        moveIcon(findViewById(R.id.imageViewAbout));
        iv=(ImageView)findViewById(R.id.imageView);
        SGD = new ScaleGestureDetector(this,new ScaleListener());
        bib = (Button) findViewById(R.id.first);
        bib.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, ListViewFoodActivity.class);
                startActivity(myIntent);
            }
        });

        pag = (Button) findViewById(R.id.page);
        pag.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, ViewPagerActivity.class);
                startActivity(myIntent);
            }
        });
        serv = (Button) findViewById(R.id.service);
        serv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, ServiceActivity.class);
                startActivity(myIntent);
            }
        });
        rad = (Button) findViewById(R.id.radiobut);
        rad.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, RadioGroupActivity.class);
                startActivity(myIntent);
            }
        });
        dialo = (Button) findViewById(R.id.dialogg);
        dialo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, DialogActivity.class);
                startActivity(myIntent);
            }
        });

        checkbox = (Button) findViewById(R.id.checkboxx);
        checkbox.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, CheckBoxActivity.class);
                startActivity(myIntent);
            }
        });

        hand = (Button) findViewById(R.id.hand_bt);
        hand.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, HandlerActivity.class);
                startActivity(myIntent);
            }
        });

        mOrder = (Button) findViewById(R.id.btnOrder);
        mItemSelected = (TextView) findViewById(R.id.tvItemSelected);

        listItems = getResources().getStringArray(R.array.shopping_item);
        checkedItems = new boolean[listItems.length];

        mOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
                mBuilder.setTitle(R.string.dialog_title);
                mBuilder.setMultiChoiceItems(listItems, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int position, boolean isChecked) {

                        if(isChecked){
                            Foods.add(position);
                        }else{
                            Foods.remove((Integer.valueOf(position)));
                        }
                    }
                });

                mBuilder.setCancelable(false);
                mBuilder.setPositiveButton(R.string.ok_label, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        String item = "";
                        for (int i = 0; i < Foods.size(); i++) {
                            item = item + listItems[Foods.get(i)];
                            if (i != Foods.size() - 1) {
                                item = item + ", ";
                            }
                        }
                        mItemSelected.setText(item);
                    }
                });

                mBuilder.setNegativeButton(R.string.dismiss_label, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

                mBuilder.setNeutralButton(R.string.clear_all_label, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        for (int i = 0; i < checkedItems.length; i++) {
                            checkedItems[i] = false;
                            Foods.clear();
                            mItemSelected.setText("");
                        }
                    }
                });

                AlertDialog mDialog = mBuilder.create();
                mDialog.show();
            }
        });












    }


    private void moveIcon(View view) {
        int originalPos[] = new int[2];
        view.getLocationOnScreen(originalPos);

        anim2 = new TranslateAnimation(0, 0, 0, originalPos[1] + 1000);
        anim2.setDuration(5000);
        anim2.setFillAfter(true);
        view.startAnimation(anim2);
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        return false;
    }


    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }



    public boolean onTouchEvent(MotionEvent ev) {
        SGD.onTouchEvent(ev);
        return true;
    }

    private class ScaleListener extends ScaleGestureDetector.
            SimpleOnScaleGestureListener {

        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            scale *= detector.getScaleFactor();
            scale = Math.max(0.1f, Math.min(scale, 5.0f));
            matrix.setScale(scale, scale);
            iv.setImageMatrix(matrix);
            return true;
        }
    }



}