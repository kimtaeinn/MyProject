package com.example.taeinkim.openmovieinfo;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by TAEIN.KIM on 2017-10-22.
 */

public class MovieInfoListAdapter extends BaseAdapter {

    private ArrayList<MovieInfoListItem> movieInfoListItems = new ArrayList<MovieInfoListItem>();

    @Override
    public int getCount() {
        return movieInfoListItems.size();
    }

    @Override
    public Object getItem(int position) {
        return movieInfoListItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {



        return null;
    }
}
