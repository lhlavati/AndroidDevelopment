package luka.ferit.interactivitymessaging;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etMessage, etMessage2;
    Button btnCallSecondActivity, btnCallThirdActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
    }

    private void initUI() {
        etMessage = findViewById(R.id.etMessage);
        etMessage2 = findViewById(R.id.etMessage2);
        btnCallSecondActivity = findViewById(R.id.button);
        btnCallThirdActivity = findViewById(R.id.btnCallThird);
        btnCallSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActivitySecond.class);
                String message = etMessage.getText().toString();
                intent.putExtra("msg", message);
                startActivity(intent);
            }
        });

        btnCallThirdActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActivityThird.class);
                startActivityForResult(intent, 10);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 10:
                if(resultCode == RESULT_OK){
                    processData(data.getExtras());
                }
                break;
        }
    }

    private void processData(Bundle extras) {
        if(extras.containsKey("msgFrom3rd")){
            String message = extras.getString("msgFrom3rd");
            etMessage.setText(message);
        }
    }
}
