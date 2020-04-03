package com.zoumzoum.zoum;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class AwardOnly extends Activity
{
    Button buttonReturn, Logout;
    ListView awardOnlyListView;
/*
    int title[] = {R.string.MOFA, R.string.SINOPAC, R.string.NCKUAward, R.string.Olympiad};

    int location[] = {R.string.MOFALocation, R.string.SINOPACLocation,R.string.NCKUAwardLocation, R.string.OlympiadLocation};

    int date[] = {R.string.MOFADate, R.string.SINOPACDate, R.string.NCKUAwardDate, R.string.OlympiadDate};

    int number[] = {1, 2, 3, 4};


    int organizer[] = {R.string.MOFAOrganizer, R.string.SINOPACOrganizer, R.string.NCKUAwardOrganizer,R.string.OlympiadOrganizer};



 */

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_award_only);

        Logout = findViewById(R.id.outAwardOnly);
        Logout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AwardOnly.this, Signup.class);
                startActivity(intent);
            }
        });

        // blink logout

        Button logOut = findViewById(R.id.outAwardOnly);

        Animation animButton = new AlphaAnimation(0.0f, 1.0f);
        animButton.setDuration(100); //You can manage the blinking time with this parameter
        animButton.setStartOffset(20);
        animButton.setRepeatMode(Animation.REVERSE);
        animButton.setRepeatCount(Animation.INFINITE);
        logOut.startAnimation(animButton);

        // Return Button
        buttonReturn = findViewById(R.id.awardOnlyToMainID);


        buttonReturn.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(AwardOnly.this, Award.class);
                startActivity(intent);

            }
        });


        // Setting ListView
        Resources res = getResources();

        String title[] = res.getStringArray(R.array.awardOnlyTitle);
        String location[] = res.getStringArray(R.array.awardOnlyLocation);
        String date[] = res.getStringArray(R.array.awardOnlyDate);
        String number[] = res.getStringArray(R.array.awardOnlyNumber);
        String organizer[] = res.getStringArray(R.array.awardOnlyOrganizer);
        awardOnlyListView = findViewById(R.id.awardOnlyListView);
        AwardOnlyAdapter adp = new AwardOnlyAdapter(getApplicationContext(),title, location, date, number, organizer) ;
        awardOnlyListView.setAdapter(adp);
    }// End of onCreate

    @Override
    public void onBackPressed() { }
}
