package com.cvaghela.spinner.searchablespinner.interfaces;

import android.view.View;

/**
 * Created by mudassar on 6/4/20.
 */

public interface ISpinnerSelectedView {
    View getNoSelectionView();

    View getSelectedView(int position);
}
