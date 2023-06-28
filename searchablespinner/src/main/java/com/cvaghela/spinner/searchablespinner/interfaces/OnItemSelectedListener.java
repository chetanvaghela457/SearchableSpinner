package com.cvaghela.spinner.searchablespinner.interfaces;

import android.view.View;

/**
 * Created by chetan532 on 28/6/23.
 */

public interface OnItemSelectedListener {
    void onItemSelected(View view, int position, long id);

    void onNothingSelected();
}
