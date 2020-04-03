package com.zoumzoum.zoum;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

public class Award extends Activity
{
    Button buttonReturn, Logout;
    ListView awardListView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_award);

        // Logout Button

        Logout = findViewById(R.id.outAward);
        Logout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Award.this, Signup.class);
                startActivity(intent);
            }
        });

        // Blink Logout

        Button logOut = findViewById(R.id.outAward);

        Animation animButton = new AlphaAnimation(0.0f, 1.0f);
        animButton.setDuration(100); //You can manage the blinking time with this parameter
        animButton.setStartOffset(20);
        animButton.setRepeatMode(Animation.REVERSE);
        animButton.setRepeatCount(Animation.INFINITE);
        logOut.startAnimation(animButton);

        // Return Button
        buttonReturn = findViewById(R.id.awardPublicationToMenuID);
        buttonReturn.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Award.this, MainActivity.class);
                startActivity(intent);

            }
        });


        // Setting ListView
        Resources res = getResources();

        String item[] = res.getStringArray(R.array.awardItem);

        awardListView = findViewById(R.id.awardListView);

        AwardAdapter adp = new AwardAdapter(getApplicationContext(),item) ;
        awardListView.setAdapter(adp);

        // ListView click event
        awardListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {


                if (position == 0)
                {
                    Intent newActivity1 = new Intent(getApplicationContext(), AwardOnly.class);
                    startActivity(newActivity1);
                }

                if (position == 1)
                {
                    Intent newActivity2 = new Intent(getApplicationContext(), Publication.class);
                    startActivity(newActivity2);
                }


            }


        });// End of awardListView  click event




    }// End of onCreate

    @Override
    public void onBackPressed() { }

}
