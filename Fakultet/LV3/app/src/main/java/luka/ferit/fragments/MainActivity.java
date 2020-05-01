package luka.ferit.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends FragmentActivity implements EditFragment.TextChangeListener, EditFragment.ChangeTextColorListener {
    private static final String LOG_TAG = "Luka";
    private Button bSwitchFragments;
    public boolean mAreSwitched = false;
    private final String EDIT_FRAGMENT = "Edit_fragment";
    private final String DISPLAY_FRAGMENT = "Display_fragment";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setUpFragments();
        this.setUpUI();
    }
    private void setUpUI() {
        this.bSwitchFragments = (Button) findViewById(R.id.bSwitchFragments);
        this.bSwitchFragments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction =
                        fragmentManager.beginTransaction();
                if(mAreSwitched){
                    fragmentTransaction.replace(R.id.flPrimary,new EditFragment(),EDIT_FRAGMENT);
                    fragmentTransaction.replace(R.id.flSecondary,new DisplayFragment(),DISPLAY_FRAGMENT);
                }
                else {
                    fragmentTransaction.replace(R.id.flPrimary,new DisplayFragment(),DISPLAY_FRAGMENT);
                    fragmentTransaction.replace(R.id.flSecondary,new EditFragment(),EDIT_FRAGMENT);
                }
                fragmentTransaction.commit();
                mAreSwitched = !mAreSwitched;
            }
        });
    }
    private void setUpFragments() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.flPrimary,new EditFragment(),this.EDIT_FRAGMENT);
        fragmentTransaction.add(R.id.flSecondary,new DisplayFragment(),this.DISPLAY_FRAGMENT);
        fragmentTransaction.commit();
    }
    @Override
    public void onTextChange(int TextSize, String TextMessage) {
        Log.d(LOG_TAG,"In event handler");
        FragmentManager fragmentManager = getSupportFragmentManager();
        DisplayFragment displayFragment = (DisplayFragment) fragmentManager.findFragmentByTag(this.DISPLAY_FRAGMENT);
        displayFragment.setText(TextSize,TextMessage);
    }

    public void changeColorText(int color) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        DisplayFragment displayFragment = (DisplayFragment) fragmentManager.findFragmentByTag(this.DISPLAY_FRAGMENT);
        displayFragment.setColor(color);
    }
}
