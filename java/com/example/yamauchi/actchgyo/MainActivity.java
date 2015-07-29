package com.example.yamauchi.actchgyo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.provider.Settings;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity
        implements View.OnClickListener
{

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        LinearLayout layout = new LinearLayout(this);
        layout.setBackgroundColor(Color.WHITE);
        layout.setOrientation(LinearLayout.VERTICAL);
        setContentView(layout);

        int wc = LinearLayout.LayoutParams.WRAP_CONTENT;

        // ボタンの生成、追加
        Button btn = new Button(this);
        btn.setText("PUSH");
        btn.setTag("btn1");
        btn.setLayoutParams(new LinearLayout.LayoutParams(300, wc));
        btn.setOnClickListener(this);
        layout.addView(btn);

        // テキストビューの生成、追加
        tv = new TextView(this);
        tv.setText("???");
        tv.setLayoutParams(new LinearLayout.LayoutParams(wc, wc));
        layout.addView(tv);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        String tag = (String)v.getTag();
        if(tag == "btn1"){
			/*Intent it = new Intent(this, SubActivity.class);
			it.putExtra("param", "ABC");
			startActivityForResult(it, 0);*/
            //Uri  uri = Uri.parse("http://www.it-college.ac.jp");
			//Uri  uri = Uri.parse("geo:0.0?q=Naha");
            Uri uri = Uri.parse("tel:117");
			//Intent it = new Intent(Intent.ACTION_VIEW, uri);
			Intent it = new Intent(Intent.ACTION_DIAL, uri);
            //Intent it = new Intent(Settings.ACTION_SETTINGS);
            startActivity(it);

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 0 && resultCode == Activity.RESULT_OK){
            Bundle extras = data.getExtras();
            if(extras != null){
                tv.setText(extras.getString("return"));
            }
        }
    }
}
