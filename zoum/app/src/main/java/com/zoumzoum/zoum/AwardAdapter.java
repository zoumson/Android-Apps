package com.zoumzoum.zoum;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class AwardAdapter extends BaseAdapter
{
    Context context;
    String item[];

    LayoutInflater inflter;

    public AwardAdapter(Context applicationContext, String[] item)
    {
        this.context = applicationContext;
        this.item = item;

        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() { return item.length; }

    @Override
    public Object getItem(int i) { return null; }

    @Override
    public long getItemId(int i) { return 0; }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        view = inflter.inflate(R.layout.activity_award_list_view_item, null);

        TextView it =  view.findViewById(R.id.awardItem);

        it.setText(item[i]);


        return view;
    }

}

