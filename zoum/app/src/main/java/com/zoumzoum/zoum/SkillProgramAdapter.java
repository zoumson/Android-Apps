package com.zoumzoum.zoum;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ProgressBar;

import com.github.lzyzsd.circleprogress.CircleProgress;
import com.github.lzyzsd.circleprogress.DonutProgress;


public class SkillProgramAdapter extends BaseAdapter
{
    Context context;
    String skill[];
    int logo[];
    int bar [];
    LayoutInflater inflter;

    public SkillProgramAdapter(Context applicationContext, String[] skill, int[] logo, int[] bar)
    {
        this.context = context;
        this.skill = skill;
        this.logo = logo;
        this.bar = bar;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() { return skill.length; }

    @Override
    public Object getItem(int i) { return null; }

    @Override
    public long getItemId(int i) { return 0; }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        view = inflter.inflate(R.layout.activity_skill_program_item, null);

        TextView skillTxt = view.findViewById(R.id.skillProgramTxt);
        ImageView skillImg =  view.findViewById(R.id.skillProgramImgID);
        //ProgressBar skillBar =  view.findViewById(R.id.skillProgramBarID);
        DonutProgress skillBar =  view.findViewById(R.id.skillProgramBarID);

        skillTxt.setText(skill[i]);
        skillImg.setImageResource(logo[i]);
        skillBar.setProgress(bar[i]);
        return view;
    }
}