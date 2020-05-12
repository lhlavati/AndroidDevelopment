package luka.ferit.guessthenumber;

import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyCustomAdapter extends RecyclerView.Adapter<MyCustomAdapter.ViewHolder>{

    private String TAG = "MyCustomAdapter";
    private ArrayList<String> values;

    public MyCustomAdapter(ArrayList<String> values) {
        this.values = values;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView txtHeader;
        public TextView txtFooter;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "MyCustomAdapter");
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
