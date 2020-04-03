package com.zoumzoum.zoum;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.ListView;

import android.widget.Button;


public class Personal extends Activity
{

    ListView personalListView;
    Button buttonReturn, Logout;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);

        Logout = findViewById(R.id.outPersonal);

        // Blink Logout

        Button logOut = findViewById(R.id.outPersonal);

        Animation animButton = new AlphaAnimation(0.0f, 1.0f);
        animButton.setDuration(100); //You can manage the blinking time with this parameter
        animButton.setStartOffset(20);
        animButton.setRepeatMode(Animation.REVERSE);
        animButton.setRepeatCount(Animation.INFINITE);
        logOut.startAnimation(animButton);

        // Logout click event

        Logout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(Personal.this, Signup.class);
                startActivity(intent);
            }
        });

        // Return Button

        buttonReturn = findViewById(R.id.personalToMenu);

        buttonReturn.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Personal.this, MainActivity.class);
                startActivity(intent);

            }
        });





        // Setting ListView
        Resources res = getResources();

        String title[] = res.getStringArray(R.array.personalTitle);

        String subTitle[] = res.getStringArray(R.array.personalSubTitle);

        // Getting logo from drawable
        TypedArray tArray = getResources().obtainTypedArray(R.array.personalLogo);

        int[] logos = new int[title.length];

        for (int i = 0; i < logos.length; i++) logos[i] = tArray.getResourceId(i, 0);
        tArray.recycle();

        personalListView = findViewById(R.id.personalListView);
        PersonalAdapter adp = new PersonalAdapter(getApplicationContext(), title, subTitle, logos);
        personalListView.setAdapter(adp);

        // ListView click event
        personalListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Resources res = getResources();

                String myCountryAddress, myResidentCountryAddress, myActualAddress, myGithub, myStack, myLinkedIn;

                myLinkedIn = res.getString(R.string.myLinkedIn);
                myGithub = res.getString(R.string.myGithub);
                myStack = res.getString(R.string.myStackOverflow);
                myCountryAddress = res.getString(R.string.myCountryAddress);
                myResidentCountryAddress = res.getString(R.string.myResidentCountryAddress);
                myActualAddress = res.getString(R.string.myActualAddress);

                if (position == 0)
                {
                    Intent intent = new Intent(Personal.this, Career.class);
                    startActivity(intent);
                }

                if (position == 1)
                {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.addCategory(Intent.CATEGORY_BROWSABLE);
                    intent.setData(Uri.parse(myCountryAddress));
                    startActivity(intent);
                }

                if (position == 2)
                {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.addCategory(Intent.CATEGORY_BROWSABLE);
                    intent.setData(Uri.parse(myResidentCountryAddress));
                    startActivity(intent);
                }

                if (position == 3)
                {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.addCategory(Intent.CATEGORY_BROWSABLE);
                    intent.setData(Uri.parse(myActualAddress));
                    startActivity(intent);
                }

                if(position == 6)
                {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.addCategory(Intent.CATEGORY_BROWSABLE);
                    intent.setData(Uri.parse(myLinkedIn));
                    startActivity(intent);
                }
                if(position == 7)
                {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.addCategory(Intent.CATEGORY_BROWSABLE);
                    intent.setData(Uri.parse(myGithub));
                    startActivity(intent);
                }

                if(position == 8)
                {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.addCategory(Intent.CATEGORY_BROWSABLE);
                    intent.setData(Uri.parse(myStack));
                    startActivity(intent);
                }




            }


        });// End of personalListView  click event







    }// End of onCreate

    @Override
    public void onBackPressed() { }

}









