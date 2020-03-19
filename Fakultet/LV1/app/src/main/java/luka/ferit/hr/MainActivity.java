package luka.ferit.hr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText height, weight;
    TextView numBMI, txtBMI, descBMI;
    Button calculate;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);
        numBMI = findViewById(R.id.numBMI);
        txtBMI = findViewById(R.id.txtBMI);
        descBMI = findViewById(R.id.descBMI);
        calculate = findViewById(R.id.button);
        image = findViewById(R.id.imageView);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        String heightStr = height.getText().toString();
        String weightStr = weight.getText().toString();

        if(heightStr != null && !"".equals(heightStr) && weightStr != null && !"".equals(weightStr)){
            double heightValue = Double.parseDouble(heightStr) / 100;
            double weightValue = Double.parseDouble(weightStr);
            
            double bmi = weightValue / (heightValue * heightValue);
            displayBMI(bmi);
        }
    }

    private void displayBMI(double bmi) {
        String doubleBMI = String.format("%.2f", bmi);
        if(Double.compare(bmi, 15d) <= 0 && Double.compare(bmi, 18.5d) <= 0) {
            numBMI.setText(doubleBMI);
            txtBMI.setText(R.string.underweight);
            descBMI.setText(R.string.descUnderweight);
            image.setVisibility(View.INVISIBLE);
        } else if (Double.compare(bmi, 18.5d) > 0 && Double.compare(bmi, 25d) <= 0){
            numBMI.setText(doubleBMI);
            txtBMI.setText(R.string.normal);
            descBMI.setText(R.string.descNormal);
            image.setVisibility(View.INVISIBLE);
        } else if (Double.compare(bmi, 25d) > 0 && Double.compare(bmi, 30d) <= 0) {
            numBMI.setText(doubleBMI);
            txtBMI.setText(R.string.overweight);
            descBMI.setText(R.string.descOverweight);
            image.setVisibility(View.INVISIBLE);
        } else if (Double.compare(bmi, 30d) > 0 && Double.compare(bmi, 40d) <= 0) {
            numBMI.setText(doubleBMI);
            txtBMI.setText(R.string.obesity);
            descBMI.setText(R.string.descObesity);
            image.setVisibility(View.VISIBLE);
        }
    }
}
