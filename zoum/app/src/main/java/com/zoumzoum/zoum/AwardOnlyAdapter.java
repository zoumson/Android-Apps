package com.zoumzoum.zoum;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import android.widget.TextView;

public class AwardOnlyAdapter extends BaseAdapter
{
    Context context;
    String title[];
    String location[];
    String date[];
    String number[];
    String organizer[];

    LayoutInflater inflter;

    public AwardOnlyAdapter(Context applicationContext, String[] title, String []location, String[] date, String [] number, String[] organizer)
    {
        this.context = applicationContext;
        this.date = date;
        this.number = number;
        this.location = location;
        this.title = title;
        this.organizer = organizer;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() { return title.length; }

    @Override
    public Object getItem(int i) { return null; }

    @Override
    public long getItemId(int i) { return 0; }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        view = inflter.inflate(R.layout.activity_award_only_item, null);


        TextView tit =  view.findViewById(R.id.awardOnlyItemTitle);

        TextView loc =  view.findViewById(R.id.awardOnlyItemLocation);

        TextView dat =  view.findViewById(R.id.awardOnlyItemDate);

        TextView org =  view.findViewById(R.id.awardOnlyItemOrganizer);

        TextView num =  view.findViewById(R.id.awardOnlyItemNumber);

        tit.setText(title[i]);
        num.setText(String.valueOf(number[i]));
        loc.setText(location[i]);
        org.setText(organizer[i]);
        dat.setText(date[i]);

        return view;
    }

}
