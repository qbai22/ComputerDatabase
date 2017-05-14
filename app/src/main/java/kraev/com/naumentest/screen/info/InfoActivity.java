package kraev.com.naumentest.screen.info;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by qbai on 11.05.2017.
 */

public class InfoActivity extends AppCompatActivity {

    public static void start(@NonNull Activity activity){
        Intent intent = new Intent(activity, InfoActivity.class);
        activity.startActivity(intent);
    }

}
