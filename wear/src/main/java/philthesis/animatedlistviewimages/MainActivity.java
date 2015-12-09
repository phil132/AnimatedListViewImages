package philthesis.animatedlistviewimages;

import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.support.wearable.view.BoxInsetLayout;
import android.support.wearable.view.WearableListView;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends WearableActivity
        implements WearableListView.ClickListener {

    private static final SimpleDateFormat AMBIENT_DATE_FORMAT =
            new SimpleDateFormat("HH:mm", Locale.US);

    //private BoxInsetLayout mContainerView;
    private TextView mTextView;
    private static ArrayList<Integer> mIcons;
    //private TextView mClockView;


    String[] elements = {"smart fortwo", "List Item 2", "Mini"};
    String[] distances = {"300", "400 m", "5000m"};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setAmbientEnabled();

        mIcons = new ArrayList<Integer>();
        mIcons.add(R.drawable.emio_circle_selected);
        mIcons.add(R.drawable.drivenow_circle_selected);
        mIcons.add(R.drawable.car2go_circle_selected);
        mIcons.add(R.drawable.common_google_signin_btn_icon_light_normal);
        mIcons.add(R.drawable.common_google_signin_btn_icon_dark_normal);

        //mContainerView = (BoxInsetLayout) findViewById(R.id.container);
        mTextView = (TextView) findViewById(R.id.text);
       // mClockView = (TextView) findViewById(R.id.clock);

        WearableListView vehicleListView = (WearableListView) findViewById(R.id.wearable_list);

        vehicleListView.setAdapter(new WearableListAdapter(this, elements, distances, mIcons));

        vehicleListView.setClickListener(this);
    }
/*
    @Override
    public void onEnterAmbient(Bundle ambientDetails) {
        super.onEnterAmbient(ambientDetails);
        updateDisplay();
    }

    @Override
    public void onUpdateAmbient() {
        super.onUpdateAmbient();
        updateDisplay();
    }

    @Override
    public void onExitAmbient() {
        updateDisplay();
        super.onExitAmbient();
    }

    private void updateDisplay() {
        if (isAmbient()) {
            mContainerView.setBackgroundColor(getResources().getColor(android.R.color.black));
            mTextView.setTextColor(getResources().getColor(android.R.color.white));
            mClockView.setVisibility(View.VISIBLE);

            mClockView.setText(AMBIENT_DATE_FORMAT.format(new Date()));
        } else {
            mContainerView.setBackground(null);
            mTextView.setTextColor(getResources().getColor(android.R.color.black));
            mClockView.setVisibility(View.GONE);
        }
    }*/

    @Override
    public void onClick(WearableListView.ViewHolder viewHolder) {
        //// TODO: 08.12.2015 actions
    }

    @Override
    public void onTopEmptyRegionClick() {

    }
}
