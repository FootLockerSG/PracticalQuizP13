package sg.edu.rp.c346.practicalquiz;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    BroadcastReceiver br = new MessageReciever();
    RadioButton rb1;
    RadioButton rb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rb1 = findViewById(R.id.radioButton);
        rb2 = findViewById(R.id.radioButton2);


        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        filter.addAction("android.intent.action.WALLPAPER_CHANGED");
        this.registerReceiver(br,filter);
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.unregisterReceiver(br);
    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        if(rb1.isChecked()){
            editor.clear();
            editor.putInt("1",1);
            editor.commit();
        }
        else if (rb2.isChecked()){
            editor.clear();
            editor.putInt("1",2);
            editor.commit();
        }
    }
}
