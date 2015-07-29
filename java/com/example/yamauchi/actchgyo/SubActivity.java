package com.example.yamauchi.actchgyo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

/**
 * Created by yamauchi on 2015/07/29.
 */
public class SubActivity extends AppCompatActivity
        implements View.OnTouchListener
{

    private String text ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            text = extras.getString("param");
        }

        TextView tv = new TextView(this);
        tv.setText("SubActivity: " + text);
        setContentView(tv);

        tv.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int action = event.getAction();
        if((action & MotionEvent.ACTION_MASK) == MotionEvent.ACTION_DOWN){
            Intent it = new Intent();
            it.putExtra("return", text);
            setResult(Activity.RESULT_OK, it);
            finish();
        }
        return false;
    }
}
