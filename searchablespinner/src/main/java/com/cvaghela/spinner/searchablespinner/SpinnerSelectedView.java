package com.cvaghela.spinner.searchablespinner;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

import androidx.annotation.IdRes;

/**
 * Created by chetan532 on 28/6/23.
 */

public class SpinnerSelectedView implements Parcelable {
    public static final Creator<SpinnerSelectedView> CREATOR = new Creator<SpinnerSelectedView>() {
        @Override
        public SpinnerSelectedView createFromParcel(Parcel in) {
            return new SpinnerSelectedView(in);
        }

        @Override
        public SpinnerSelectedView[] newArray(int size) {
            return new SpinnerSelectedView[size];
        }
    };
    private             View                  mView;
    private             int                   mPosition;
    private @IdRes
                        long                  mId;

    public SpinnerSelectedView(View view, int position, @IdRes long id) {
        mView     = view;
        mPosition = position;
        mId       = id;
    }

    protected SpinnerSelectedView(Parcel in) {
        mPosition = in.readInt();
        mId       = in.readLong();
    }

    public View getView() {
        return mView;
    }

    public void setView(View view) {
        mView = view;
    }

    public int getPosition() {
        return mPosition;
    }

    public void setPosition(int position) {
        mPosition = position;
    }

    public long getId() {
        return mId;
    }

    public void setId(@IdRes long id) {
        mId = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SpinnerSelectedView that = (SpinnerSelectedView) o;

        if (mPosition != that.mPosition) return false;
        if (mId != that.mId) return false;
        return mView != null ? mView.equals(that.mView) : that.mView == null;

    }

    @Override
    public int hashCode() {
        int result = mView != null ? mView.hashCode() : 0;
        result = 31 * result + mPosition;
        result = 31 * result + (int) (mId ^ (mId >>> 32));
        return result;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mPosition);
        dest.writeLong(mId);
    }
}
