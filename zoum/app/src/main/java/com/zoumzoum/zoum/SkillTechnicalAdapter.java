package com.zoumzoum.zoum;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class SkillTechnicalAdapter extends BaseAdapter
{
    Context context;


    SkillTechnicalListItem item[];

    LayoutInflater inflter;

    public SkillTechnicalAdapter(Context applicationContext, SkillTechnicalListItem[] item)
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
        view = inflter.inflate(R.layout.activity_skill_technical_item, null);
        TextView header =  view.findViewById(R.id.technicalSkillItemHeader);
        //grid1 = findViewById(R.id.technicalGridView1); // init GridView
        // Create an object of CustomAdapter and set Adapter to GirdView
        //GridCustomAdapter customAdapter1 = new GridCustomAdapter(getApplicationContext(), item1);
        //grid1.setAdapter(customAdapter1);
        header.setText(item[i].header);

        GridView gri = view.findViewById(R.id.technicalSkillItemGridView);
        SkillTechnicalGridAdapter adapt = new SkillTechnicalGridAdapter(context, item[i].gridContent);
        gri.setAdapter(adapt);
        return view;
    }



}
