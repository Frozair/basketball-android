package com.newrdev.basketball.ui.scoreboard;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.newrdev.basketball.ui.util.FontCache;

/**
 * Created by newrdev on 7/25/16.
 */
public class ScoreboardTextView extends TextView
{
    public ScoreboardTextView(Context context) {
        super(context);

        applyCustomFont(context);
    }

    public ScoreboardTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        applyCustomFont(context);
    }

    public ScoreboardTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        applyCustomFont(context);
    }

    private void applyCustomFont(Context context) {
        Typeface customFont = FontCache.getTypeface("fonts/scoreboard.ttf", context);
        setTypeface(customFont);
    }
}
