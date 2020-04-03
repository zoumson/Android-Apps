package com.zoumzoum.zoum;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


public class SkillTechnicalGridAdapter extends BaseAdapter
{
    Context context;
    String logos[];
    LayoutInflater inflter;
    public SkillTechnicalGridAdapter(Context applicationContext, String[] logos)
    {
        this.context = applicationContext;
        this.logos = logos;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() { return logos.length; }
    @Override
    public Object getItem(int i) { return null; }
    @Override
    public long getItemId(int i) { return 0; }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        view = inflter.inflate(R.layout.activity_gridview, null); // inflate the layout
        TextView txt = view.findViewById(R.id.skillTxtID); // get the reference of ImageView
        txt.setText(logos[i]); // set logo images
        return view;
    }
}