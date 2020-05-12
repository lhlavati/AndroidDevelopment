package luka.ferit.guessthenumber;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String TAG = "MainActivity";
    private RecyclerView recyclerView;
    private LinearLayoutManager mLayoutManager;
    private MyCustomAdapter myCustomAdapter;
    private ArrayList<String> values;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        values = new ArrayList<>();

        for (int i = 0; i < 100; i++){
            values.add("Item" + i);
        }

        myCustomAdapter = new MyCustomAdapter(values);
        recyclerView.setAdapter(myCustomAdapter);
    }
}
