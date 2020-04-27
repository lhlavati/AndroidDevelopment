package luka.ferit.lv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonTemp, buttonDist, buttonVol, buttonSpeed;
    private static final String LOG_TAG = "converter";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setView();
    }

    private void setView(){

        buttonTemp = findViewById(R.id.buttonTemp);
        buttonDist = findViewById(R.id.buttonDist);
        buttonVol = findViewById(R.id.buttonVol);
        buttonSpeed = findViewById(R.id.buttonSpeed);

        buttonTemp.setOnClickListener(this);
        buttonDist.setOnClickListener(this);
        buttonVol.setOnClickListener(this);
        buttonSpeed.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Log.d(LOG_TAG, "MainActivity onClick");
        switch (v.getId()){
            case R.id.buttonTemp:
                Log.d(LOG_TAG, "MainActivity onClick buttonTemp");
                break;
            case R.id.buttonDist:
                Log.d(LOG_TAG, "MainActivity onClick buttonDist");
                Intent intent = new Intent(this, DistanceActivity.class);
                startActivity(intent);
                break;
            case R.id.buttonVol:
                Log.d(LOG_TAG, "MainActivity onClick buttonVol");
                break;
            case R.id.buttonSpeed:
                Log.d(LOG_TAG, "MainActivity onClick buttonSpeed");
                break;

            default:
                break;
        }
    }


}
