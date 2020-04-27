package luka.ferit.lv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DistanceActivity extends AppCompatActivity {

    private static final String LOG_TAG = "converter";

    private Button button;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distance);
        Log.d(LOG_TAG, "MainActivity onCreate");
        setView();
    }

    private void setView(){
        Log.d(LOG_TAG, "MainActivity setView");
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(LOG_TAG, "MainActivity onClick");
                String value = editText.getText().toString();
                Intent intent = new Intent(DistanceActivity.this, DistanceCalcActivity.class);
                intent.putExtra("value", value);
                startActivity(intent);
            }
        });
    }
}
