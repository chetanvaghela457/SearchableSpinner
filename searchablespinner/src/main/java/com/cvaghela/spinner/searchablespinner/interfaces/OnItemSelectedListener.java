package com.cvaghela.spinner.searchablespinner.interfaces;

import android.view.View;

/**
 * Created by mudassar on 6/4/20.
 */

public interface OnItemSelectedListener {
    void onItemSelected(View view, int position, long id);

    void onNothingSelected();
}
