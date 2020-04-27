package luka.ferit.lv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class DistanceCalcActivity extends AppCompatActivity {

    private static final String LOG_TAG = "converter";
    private TextView textViewValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distance_calc);
        Log.d(LOG_TAG, "MainActivity onCreate");
        setView();
        getDataFromIntent();
    }

    private void getDataFromIntent() {


    }

    private void setView() {
        Log.d(LOG_TAG, "MainActivity setView");
        textViewValue = findViewById(R.id.textViewValue);
    }
}
