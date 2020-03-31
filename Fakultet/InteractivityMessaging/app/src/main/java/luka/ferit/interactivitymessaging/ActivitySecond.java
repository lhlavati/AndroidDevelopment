package luka.ferit.interactivitymessaging;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivitySecond extends AppCompatActivity {

    Button btnFinish2nd;
    TextView tvMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initUI();
    }

    private void initUI(){
        tvMessage = findViewById(R.id.tvMessage);
        btnFinish2nd = findViewById(R.id.btnFinish2nd);
        btnFinish2nd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Intent intent = getIntent();
        if(intent.hasExtra("msg")){
            String message = intent.getStringExtra("msg");
            tvMessage.setText(message);
        }
    }

}
