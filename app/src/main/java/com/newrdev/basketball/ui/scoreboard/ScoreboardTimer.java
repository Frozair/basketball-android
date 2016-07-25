package com.newrdev.basketball.ui.scoreboard;

import android.os.CountDownTimer;

/**
 * Created by newrdev on 7/24/16.
 */
public class ScoreboardTimer
{
    private static ScoreboardTimer mInstance = null;

    private long mStartTime;
    private long mCurrentTime;
    private boolean mCounting;
    private CountDownTimer mCountdownTimer;
    private Listener mListener;

    private ScoreboardTimer() {
        mStartTime = 0;
        mCurrentTime = 0;
        mCounting = false;
    }

    public static ScoreboardTimer getInstance()
    {
        if( mInstance == null )
        {
            mInstance = new ScoreboardTimer();
        }

        return mInstance;
    }

    public void setListener(Listener listener)
    {
        mListener = listener;
    }

    public void setStartTime(long startTime)
    {
        mStartTime = startTime;
        mCurrentTime = startTime;
    }

    public void start()
    {
        if( !mCounting ) {
            mCounting = true;

            mCountdownTimer = new CountDownTimer(mCurrentTime, 1000) {

                public void onTick(long millisUntilFinished) {
                    mCurrentTime = millisUntilFinished;

                    if (mListener != null) {
                        mListener.onTick((millisUntilFinished / 1000));
                    }
                }

                public void onFinish() {
                    if (mListener != null) {
                        mListener.onFinish();
                    }

                    mCurrentTime = mStartTime;
                }
            }.start();
        }
    }

    public void pause()
    {
        mCounting = false;
        mCountdownTimer.cancel();
    }

    public void stop()
    {
        mCounting = false;
        mStartTime = 0;
        mCurrentTime = 0;
        mCountdownTimer.cancel();
    }

    public void release()
    {
        if( mCountdownTimer != null )
        {
            mCountdownTimer.cancel();
            mCountdownTimer = null;
        }
    }

    public interface Listener {
        void onTick(long seconds);
        void onFinish();
    }
}
