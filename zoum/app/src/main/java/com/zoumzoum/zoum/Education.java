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

public class Education extends Activity
{
    Button buttonReturn, Logout;
    ListView educationListView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education);

        // Logout Button
        Logout = findViewById(R.id.outEducation);
        Logout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(Education.this, Signup.class);
                startActivity(intent);
            }
        });

        // Blink logout

        Button logOut = findViewById(R.id.outEducation);

        Animation animButton = new AlphaAnimation(0.0f, 1.0f);
        animButton.setDuration(100); //You can manage the blinking time with this parameter
        animButton.setStartOffset(20);
        animButton.setRepeatMode(Animation.REVERSE);
        animButton.setRepeatCount(Animation.INFINITE);
        logOut.startAnimation(animButton);

        // Return Button
        buttonReturn = findViewById(R.id.educationToMenuID);

        buttonReturn.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Education.this, MainActivity.class);
                startActivity(intent);

            }
        });

        // Setting ListView
        Resources res = getResources();

        String title[] = res.getStringArray(R.array.educationTitle);
        String location[] = res.getStringArray(R.array.educationLocation);
        String date[] = res.getStringArray(R.array.educationDate);
        String number[] = res.getStringArray(R.array.educationNumber);
        String organizer[] = res.getStringArray(R.array.educationOrganizer);
        educationListView = findViewById(R.id.educationListView);

        AwardOnlyAdapter adp = new AwardOnlyAdapter(getApplicationContext(),title, location, date, number, organizer) ;
        educationListView.setAdapter(adp);
    }// End of onCreate

    @Override
    public void onBackPressed() { }
}
