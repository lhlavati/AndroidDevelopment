package luka.ferit.interactivitymessaging;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityThird extends AppCompatActivity {

    EditText etMessageFrom3rd;
    Button btnFinishAndSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        initUI();
    }

    private void initUI(){
        etMessageFrom3rd = findViewById(R.id.etMessage3);
        btnFinishAndSend = findViewById(R.id.btnThird);
        btnFinishAndSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message3 = etMessageFrom3rd.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("msgFromThird", message3);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
