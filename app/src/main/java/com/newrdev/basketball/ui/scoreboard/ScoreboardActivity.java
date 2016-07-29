package com.newrdev.basketball.ui.scoreboard;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.newrdev.basketball.R;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by newrdev on 7/21/16.
 */
public class ScoreboardActivity extends Activity implements ScoreboardView
{
    private static final String STATE_CURRENT_TIME = "current_time";
    private static final String STATE_COUNTING = "counting";

    private TextView mScoreboardTimer;
    private TextView mHomeScore;
    private TextView mVisitorScore;
    private Button mButton;
    private boolean mPaused = false;
    private boolean mNewTimer = true;
    private long mCountdownTime = 180;
    private ScoreboardPresenter mPresenter;
    private NumberFormat mNumberFormat = new DecimalFormat("00");

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

        mHomeScore = (TextView)findViewById(R.id.homeScore);
        mVisitorScore = (TextView)findViewById(R.id.visitorScore);

        mScoreboardTimer = (TextView)findViewById(R.id.scoreboardTimer);
        mScoreboardTimer.setText(convertToScoreboardFormat(mCountdownTime));
        mButton = (Button) findViewById(R.id.button);

        // Set button click listeners
        (findViewById(R.id.homeMinusBtn)).setOnClickListener(mScoreClickListener);
        (findViewById(R.id.homePlusBtn)).setOnClickListener(mScoreClickListener);
        (findViewById(R.id.visitorMinusBtn)).setOnClickListener(mScoreClickListener);
        (findViewById(R.id.visitorPlusBtn)).setOnClickListener(mScoreClickListener);

        mButton.setOnClickListener(mListener);
    }

    @Override
    public void updateCountdown(long seconds) {
        mScoreboardTimer.setText(convertToScoreboardFormat(seconds));
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

    private View.OnClickListener mScoreClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            long score = 0;

            switch(v.getId())
            {
                case R.id.homeMinusBtn:
                    score = Long.valueOf(mHomeScore.getText().toString());

                    if(score > 0)
                    {
                        score--;
                    }

                    mHomeScore.setText(mNumberFormat.format(score));

                    break;

                case R.id.homePlusBtn:
                    score = Long.valueOf(mHomeScore.getText().toString());

                    if(score < 99)
                    {
                        score++;
                    }

                    mHomeScore.setText(mNumberFormat.format(score));

                    break;

                case R.id.visitorMinusBtn:
                    score = Long.valueOf(mVisitorScore.getText().toString());

                    if(score > 0)
                    {
                        score--;
                    }

                    mVisitorScore.setText(mNumberFormat.format(score));

                    break;

                case R.id.visitorPlusBtn:
                    score = Long.valueOf(mVisitorScore.getText().toString());

                    if(score < 99)
                    {
                        score++;
                    }

                    mVisitorScore.setText(mNumberFormat.format(score));

                    break;
            }
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

    private String convertToScoreboardFormat(long time)
    {
        long minutes = time / 60;
        long seconds = time % 60;

        return mNumberFormat.format(minutes) + ":" + mNumberFormat.format(seconds);
    }
}
