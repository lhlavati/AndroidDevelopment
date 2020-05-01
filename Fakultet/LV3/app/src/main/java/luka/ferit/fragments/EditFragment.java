package luka.ferit.fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.flask.colorpicker.ColorPickerView;
import com.flask.colorpicker.OnColorSelectedListener;
import com.flask.colorpicker.builder.ColorPickerClickListener;
import com.flask.colorpicker.builder.ColorPickerDialogBuilder;

import yuku.ambilwarna.AmbilWarnaDialog;

public class EditFragment extends Fragment {
    private static final String LOG_TAG = "Luka";
    private int mTextSize = 10;
    private String mTextMessage = "...";
    private EditText etTextMessage;
    private SeekBar sbTextSize;
    private Button bChangeText;
    private Button bChangeTextColor;
    int DefaultColor;
    private TextChangeListener mTextChangeListener;
    private ChangeTextColorListener mChangeTextColorListener;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View Layout = inflater.inflate(R.layout.fragment_edit,null);
        setUpUI(Layout);
        return Layout;
    }
    private void setUpUI(View layout) {
        this.etTextMessage = (EditText) layout.findViewById(R.id.etMessage);
        this.sbTextSize = (SeekBar) layout.findViewById(R.id.sbTextSize);
        this.bChangeText = (Button) layout.findViewById(R.id.btnChangeText);
        this.bChangeTextColor = (Button) layout.findViewById(R.id.btnChangeTextColor);
        this.sbTextSize.setProgress(this.mTextSize);
        this.bChangeText.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mTextMessage = etTextMessage.getText().toString();
                        mTextSize = sbTextSize.getProgress();
                        mTextChangeListener.onTextChange(mTextSize,mTextMessage);
                    }
                }
        );
        DefaultColor = ContextCompat.getColor(getActivity().getApplicationContext(), R.color.colorPrimary);
        this.bChangeTextColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openColorPicker();
            }
        });
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof TextChangeListener)
        {
            this.mTextChangeListener = (TextChangeListener) context;
            this.mChangeTextColorListener = (ChangeTextColorListener) context;
        }
    }
    @Override
    public void onDetach() {
        super.onDetach();
        this.mTextChangeListener = null;
        this.mChangeTextColorListener = null;
    }
    public interface TextChangeListener {
        void onTextChange(int TextSize, String TextMessage);
    }

    public interface ChangeTextColorListener{
        void changeColorText(int color);
    }

    public void openColorPicker(){
        ColorPickerDialogBuilder
                .with(getContext())
                .setTitle("Choose color")
                .initialColor(DefaultColor)
                .wheelType(ColorPickerView.WHEEL_TYPE.FLOWER)
                .density(12)
                .setOnColorSelectedListener(new OnColorSelectedListener() {
                    @Override
                    public void onColorSelected(int selectedColor) {

                    }
                })
                .setPositiveButton("ok", new ColorPickerClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int selectedColor, Integer[] allColors) {
                        DefaultColor = selectedColor;
                        mChangeTextColorListener.changeColorText(DefaultColor);
                    }
                })
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .build()
                .show();
    }
}