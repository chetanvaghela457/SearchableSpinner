package com.cvaghela.spinner.searchablespinner;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;
import com.cvaghela.spinner.searchablespinner.interfaces.ISpinnerSelectedView;

import java.util.ArrayList;

public class SimpleArrayWithTagAdapter extends ArrayAdapter<String> implements Filterable, ISpinnerSelectedView {

    private Context mContext;
    private ArrayList<String> mBackupStrings;
    private ArrayList<String> mStrings;
    private StringFilter mStringFilter = new StringFilter();

    public SimpleArrayWithTagAdapter(Context context, ArrayList<String> strings) {
        super(context, R.layout.tag_view_item);
        mContext = context;
        mStrings = strings;
        mBackupStrings = strings;
    }

    @Override
    public int getCount() {
        return mStrings == null ? 0 : mStrings.size();
    }

    @Override
    public String getItem(int position) {
        if (mStrings != null && position > 0)
            return mStrings.get(position);
        else
            return null;
    }

    @Override
    public long getItemId(int position) {
        if (mStrings == null && position > 0)
            return mStrings.get(position).hashCode();
        else
            return -1;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        view = View.inflate(mContext, R.layout.tag_view_item, null);
        TextView dispalyName = view.findViewById(R.id.TxtVw_DisplayName);
        ImageView letters     = view.findViewById(R.id.ImgVw_Letters);
        letters.setImageDrawable(getTextDrawable(mStrings.get(position)));
        dispalyName.setText(mStrings.get(position));
        return view;
    }

    @Override
    public View getSelectedView(int position) {
        View view = null;

        view = View.inflate(mContext, R.layout.tag_view_item, null);
        TextView dispalyName = view.findViewById(R.id.TxtVw_DisplayName);
        ImageView letters     = view.findViewById(R.id.ImgVw_Letters);
        letters.setImageDrawable(getTextDrawable(mStrings.get(position)));
        dispalyName.setText(mStrings.get(position));
        return view;
    }

    @Override
    public View getNoSelectionView() {
        View view = View.inflate(mContext, R.layout.view_list_no_selection_item, null);
        return view;
    }

    @Override
    public Filter getFilter() {
        return mStringFilter;
    }

    public class StringFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            final FilterResults filterResults = new FilterResults();
            if (TextUtils.isEmpty(constraint)) {
                filterResults.count = mBackupStrings.size();
                filterResults.values = mBackupStrings;
                return filterResults;
            }
            final ArrayList<String> filterStrings = new ArrayList<>();
            for (String text : mBackupStrings) {
                if (text.toLowerCase().contains(constraint)) {
                    filterStrings.add(text);
                }
            }
            filterResults.count = filterStrings.size();
            filterResults.values = filterStrings;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mStrings = (ArrayList) results.values;
            notifyDataSetChanged();
        }
    }

    private TextDrawable getTextDrawable(String displayName) {
        TextDrawable drawable = null;
        if (!TextUtils.isEmpty(displayName)) {
            int color2 = ColorGenerator.MATERIAL.getColor(displayName);
            drawable = new TextDrawable.Builder()
                    .setText(displayName.substring(0, 1))
                    .setWidth(UiTools.dpToPx(mContext, 32))
                    .setHeight(UiTools.dpToPx(mContext, 32))
                    .setTextColor(Color.WHITE)
                    .setShape(TextDrawable.SHAPE_ROUND_RECT)
                    .build();
        } else {
            drawable = new TextDrawable.Builder()
                    .setText("?")
                    .setWidth(UiTools.dpToPx(mContext, 32))
                    .setHeight(UiTools.dpToPx(mContext, 32))
                    .setTextColor(Color.WHITE)
                    .setShape(TextDrawable.SHAPE_ROUND_RECT)
                    .build();
        }
        return drawable;
    }
}
