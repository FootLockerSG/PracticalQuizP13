package sg.edu.rp.c346.practicalquiz;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;

public class MessageReciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        SharedPreferences shared = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        int num = shared.getInt("1",1);
        if (num == 1) {
            Toast my_toast = Toast.makeText(context,"You have a good taste!",Toast.LENGTH_LONG);
            my_toast.show();
        }
        else {
            String text1 = shared.getString("1b", "");
            Toast my_toast = Toast.makeText(context,"Bro, think twice about it.",Toast.LENGTH_LONG);
            my_toast.show();
        }

    }
}
