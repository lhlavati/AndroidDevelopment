package luka.ferit.fragments;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class DisplayFragment extends Fragment {
    TextView tvMessage;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View Layout = inflater.inflate(R.layout.fragment_display,null);
        this.tvMessage = (TextView) Layout.findViewById(R.id.tvMessage);
        return Layout;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }
    @Override
    public void onDetach() {
        super.onDetach();
    }
    public void setText(int TextSize, String TextMessage){
        this.tvMessage.setText(TextMessage);
        this.tvMessage.setTextSize(TextSize);
    }

    public void setColor(int color){
        this.tvMessage.setTextColor(color);
    }
}