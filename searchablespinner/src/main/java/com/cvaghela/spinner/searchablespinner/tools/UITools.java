package com.cvaghela.spinner.searchablespinner.tools;

import android.content.Context;

/**
 * Created by chetan532 on 28/6/23.
 */

public class UITools {

    private UITools() {
    }

    public static int dpToPx(Context context, float dp) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return Math.round(dp * scale);
    }
}
