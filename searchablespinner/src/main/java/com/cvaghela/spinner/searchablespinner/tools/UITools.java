package com.cvaghela.spinner.searchablespinner.tools;

import android.content.Context;

/**
 * Created by mudassar on 6/4/20.
 */

public class UITools {

    private UITools() {
    }

    public static int dpToPx(Context context, float dp) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return Math.round(dp * scale);
    }
}
