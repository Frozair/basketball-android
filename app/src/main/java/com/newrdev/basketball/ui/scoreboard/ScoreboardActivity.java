package com.newrdev.basketball.ui.scoreboard;

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
public class ScoreboardActivity extends Activity implements ScoreboardView
{
    private static final String STATE_CURRENT_TIME = "current_time";
    private static final String STATE_COUNTING = "counting";

    private TextView mTextField;
    private Button mButton;
    private boolean mPaused = false;
    private boolean mNewTimer = true;
    private CountDownTimer mCountdownTimer;
    private long mCountdownTime = 300000;
    private ScoreboardPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mPresenter = new ScoreboardPresenter();
        mPresenter.setView(this);

//        if (savedInstanceState != null) {
//            mCountdownTime = savedInstanceState.getLong(STATE_CURRENT_TIME, 0);
//            mPaused = savedInstanceState.getBoolean(STATE_COUNTING, false);
//
//
//        }

        mTextField = (TextView)findViewById(R.id.textView);
        mTextField.setText("" + (mCountdownTime / 1000));
        mButton = (Button) findViewById(R.id.button);

        mButton.setOnClickListener(mListener);
    }

    @Override
    public void updateCountdown(long seconds) {
        mTextField.setText("" + seconds);
    }

    private View.OnClickListener mListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if(mNewTimer)
            {
                mPresenter.setScoreboardTime(mCountdownTime);
                mNewTimer = false;
            }

            if(!mPaused) {
                mPresenter.startScoreboardTimer();
                mButton.setText("Pause");
            } else {
                mPresenter.pauseScoreboardTimer();
                mButton.setText("Start");
            }

            mPaused = !mPaused;
        }
    };

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // Make sure to call the super method so that the states of our views are saved
        super.onSaveInstanceState(outState);
        // Save our own state now
        outState.putLong(STATE_CURRENT_TIME, mCountdownTime);
        outState.putBoolean(STATE_COUNTING, mPaused);
    }
}
