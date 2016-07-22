package com.newrdev.basketball.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.newrdev.basketball.R;

/**
 * Created by newrdev on 7/21/16.
 */
public class EntryActivity extends Activity
{

    private static final String STATE_CURRENT_TIME = "current_time";
    private static final String STATE_COUNTING = "counting";

    private TextView mTextField;
    private Button mButton;
    private boolean mCounting = false;
    private CountDownTimer mCountdownTimer;
    private long mCountdownTime = 300000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            mCountdownTime = savedInstanceState.getLong(STATE_CURRENT_TIME, 0);
            mCounting = savedInstanceState.getBoolean(STATE_COUNTING, false);

            if(mCounting) {
                doTimer();
            }
        }

        mTextField = (TextView)findViewById(R.id.textView);
        mTextField.setText("" + (mCountdownTime / 1000));
        mButton = (Button) findViewById(R.id.button);

        mButton.setOnClickListener(mListener);
    }

    private void doTimer()
    {
        mCountdownTimer = new CountDownTimer(mCountdownTime, 1000) {

            public void onTick(long millisUntilFinished) {
                mTextField.setText("" + millisUntilFinished / 1000);
                mCountdownTime = millisUntilFinished;
            }

            public void onFinish() {
                mTextField.setText("done!");
            }
        }.start();
    }

    private View.OnClickListener mListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(!mCounting) {
                doTimer();
                mButton.setText("Pause");
            } else {
                mCountdownTimer.cancel();
                mButton.setText("Start");
            }

            mCounting = !mCounting;
        }
    };

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // Make sure to call the super method so that the states of our views are saved
        super.onSaveInstanceState(outState);
        // Save our own state now
        outState.putLong(STATE_CURRENT_TIME, mCountdownTime);
        outState.putBoolean(STATE_COUNTING, mCounting);
    }

    @Override
    protected void onDestroy() {

        if(mCountdownTimer != null) {
            mCountdownTimer.cancel();
            mCountdownTimer = null;
        }

        super.onDestroy();
    }
}
