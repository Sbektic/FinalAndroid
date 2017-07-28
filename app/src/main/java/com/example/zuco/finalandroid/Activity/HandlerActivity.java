package com.example.zuco.finalandroid.Activity;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.zuco.finalandroid.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HandlerActivity extends BaseActivity {

    @BindView(R.id.activity_handler_et)
    EditText editText;

    @BindView(R.id.activity_handler_bt)
    Button button;


    private final int TIMER=123;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg){
            switch (msg.what){
                case TIMER:
                    Bundle bundle = msg.getData();
                    String s = bundle.getString("msg");
                    shortToast(" Message" +s );
                    int number = Integer.valueOf(editText.getText().toString());
                    editText.setText(String.valueOf(--number));
                    if(number==0){
                        button.setText("Reset");
                        button.setOnClickListener(resetListener);
                    }else {
                        thread.run();
                    }
                    break;
                default:
            }
            super.handleMessage(msg);
        }
    };



    private View.OnClickListener startListener;
    private View.OnClickListener stopListener;
    private View.OnClickListener resetListener;
    private Thread thread;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        ButterKnife.bind(this);

        startListener = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                button.setText("Stop");
                editText.setEnabled(false);
                button.setOnClickListener(stopListener);
                startThread();
            }
        };
         stopListener = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                button.setText("Reset");
                button.setOnClickListener(resetListener);
             }
        };
         resetListener = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                button.setText("Start");
                editText.setEnabled(true);
                button.setOnClickListener(startListener);

            }
        };
        button.setOnClickListener(startListener);

        startThread();
    }
    private  void startThread(){
        
        thread = new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    Message msg = new Message();
                    Bundle bundle = new Bundle();
                    bundle.putString("msg", "TimerMessage" );
                    msg.setData(bundle);
                    msg.what = TIMER;
                    handler.sendMessage(msg);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        });
        thread.start();

    }
}
