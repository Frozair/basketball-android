package com.newrdev.basketball.ui.scoreboard;

import com.newrdev.basketball.ui.BasePresenter;

/**
 * Created by newrdev on 7/24/16.
 */
public class ScoreboardPresenter implements BasePresenter, ScoreboardTimer.Listener
{
    private ScoreboardView mScoreboardView;

    public ScoreboardPresenter()
    {
        ScoreboardTimer.getInstance().setListener(this);
    }

    public void setView(ScoreboardView scoreboardView)
    {
        mScoreboardView = scoreboardView;
    }

    public void setScoreboardTime(long seconds)
    {
        ScoreboardTimer.getInstance().update(seconds * 1000);
    }

    public void startScoreboardTimer()
    {
        ScoreboardTimer.getInstance().start();
    }

    public void pauseScoreboardTimer()
    {
        ScoreboardTimer.getInstance().pause();
    }

    public void stopScoreboardTimer()
    {
        ScoreboardTimer.getInstance().stop();
    }

    public void addToHomeScore(int points)
    {

    }

    public void addToVisitorScore(int points)
    {

    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {
        mScoreboardView = null;
//        ScoreboardTimer.getInstance().release();
    }

    @Override
    public void onTick(long seconds) {
        mScoreboardView.updateCountdown(seconds);
    }

    @Override
    public void onFinish() {
        // TODO ring the alarm
    }
}
