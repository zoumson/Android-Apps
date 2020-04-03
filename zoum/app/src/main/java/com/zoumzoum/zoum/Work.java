package com.zoumzoum.zoum;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.os.Bundle;
import android.widget.ListView;

public class Work extends Activity
{
    Button buttonReturn, Logout;
    ListView workListView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work);

        // Logout Button
        Logout = findViewById(R.id.outWork);
        Logout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Work.this, Signup.class);
                startActivity(intent);
            }
        });

        // Blink Logout

        Button logOut = findViewById(R.id.outWork);

        Animation animButton = new AlphaAnimation(0.0f, 1.0f);
        animButton.setDuration(100); //You can manage the blinking time with this parameter
        animButton.setStartOffset(20);
        animButton.setRepeatMode(Animation.REVERSE);
        animButton.setRepeatCount(Animation.INFINITE);
        logOut.startAnimation(animButton);

        // Return Button
        buttonReturn = findViewById(R.id.workToMenuID);


        buttonReturn.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Work.this, MainActivity.class);
                startActivity(intent);

            }
        });

        // Setting ListView
        Resources res = getResources();

        String title[] = res.getStringArray(R.array.workTitle);
        String location[] = res.getStringArray(R.array.workLocation);
        String date[] = res.getStringArray(R.array.workDate);
        String number[] = res.getStringArray(R.array.workNumber);
        String organizer[] = res.getStringArray(R.array.workOrganizer);

        workListView = findViewById(R.id.workListView);
        AwardOnlyAdapter adp = new AwardOnlyAdapter(getApplicationContext(),title, location, date, number, organizer) ;
        workListView.setAdapter(adp);
    }// End of onCreate

    @Override
    public void onBackPressed() { }
}
