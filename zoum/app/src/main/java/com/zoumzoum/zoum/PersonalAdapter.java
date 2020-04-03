package com.zoumzoum.zoum;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.util.TypedValue;

public class PersonalAdapter extends BaseAdapter
{

    Context context;
    String countryList1[];
    String countryList2[];
    int flags[];
    LayoutInflater inflter;

    public PersonalAdapter(Context applicationContext, String[] countryList1, String[] countryList2, int[] flags)
    {
        this.context = context;
        this.countryList1 = countryList1;
        this.countryList2 = countryList2;
        this.flags = flags;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() { return countryList1.length; }

    @Override
    public Object getItem(int i) { return null; }

    @Override
    public long getItemId(int i) { return 0; }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        view = inflter.inflate(R.layout.activity_personal_listview, null);
        TextView country1 =  view.findViewById(R.id.personalRowTxt1);
        Button country2 =  view.findViewById(R.id.personalRowTxt2);
        ImageView icon =  view.findViewById(R.id.personalRowImg);

        country1.setText(countryList1[i]);
        country2.setText(countryList2[i]);
        icon.setImageResource(flags[i]);

        if( i == 3) country2.setTextSize(TypedValue.COMPLEX_UNIT_SP,10);
        if( i == 5) country2.setTextSize(TypedValue.COMPLEX_UNIT_SP,12);

        country2.setTransformationMethod(null);// stop button text to be capital letter

        return view;
    }
}