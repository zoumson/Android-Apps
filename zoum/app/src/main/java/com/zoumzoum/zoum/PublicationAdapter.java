package com.zoumzoum.zoum;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class PublicationAdapter extends BaseAdapter
{
    Context context;
    String type[];
    String title[];
    String location[];
    String date[];
    String number[];
    String status[];
    String author[];

    LayoutInflater inflter;

    public PublicationAdapter (Context c,String type[], String[] title, String[] author, String []location, String[] date, String [] number, String [] status)
    {
        this.context = c;
        this.author = author;
        this.type = type;
        this.date = date;
        this.number = number;
        this.location = location;
        this.title = title;
        this.status = status;
        inflter = (LayoutInflater.from(c));
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
        view = inflter.inflate(R.layout.activity_publication_item, null);


        TextView tit =  view.findViewById(R.id.publicationTitle);

        TextView loc =  view.findViewById(R.id.publicationLocation);

        TextView dat =  view.findViewById(R.id.publicationDate);

        TextView num =  view.findViewById(R.id.publicationNumber);

        TextView stat =  view.findViewById(R.id.publicationStatus);

        TextView typ =  view.findViewById(R.id.publicationType);

        TextView auth =  view.findViewById(R.id.publicationAuthor);

        //String.valueOf("Submission Number: ")

        tit.setText(title[i]);
        num.setText("Submission No. "+number[i]);
        loc.setText(location[i]);
        stat.setText(status[i]);
        dat.setText(date[i]);
        auth.setText(author[i]);
        typ.setText(type[i]);

        return view;
    }

}
