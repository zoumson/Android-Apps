package com.zoumzoum.zoum;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;



public class CustomAdapter extends BaseAdapter
{
    Context context;
    String countryList[];
    int flags[];
    LayoutInflater inflter;

    public CustomAdapter(Context applicationContext, String[] countryList, int[] flags)
    {
        this.context = context;
        this.countryList = countryList;
        this.flags = flags;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() { return countryList.length; }

    @Override
    public Object getItem(int i) { return null; }

    @Override
    public long getItemId(int i) { return 0; }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        view = inflter.inflate(R.layout.activity_listview, null);
        TextView country =  view.findViewById(R.id.textView);
        ImageView iconLeft =  view.findViewById(R.id.iconLeft);
        ImageView iconRight =  view.findViewById(R.id.iconRight);
        country.setText(countryList[i]);
        iconLeft.setImageResource(flags[i]);
        iconRight.setImageResource(flags[i]);
        return view;
    }
}