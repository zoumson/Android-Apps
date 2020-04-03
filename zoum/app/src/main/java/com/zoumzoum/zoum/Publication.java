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

public class Publication extends Activity
{
    Button buttonReturn, Logout;
    ListView publicationListView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publication);

        // Logout Button
        Logout = findViewById(R.id.outPublication);
        Logout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Publication.this, Signup.class);
                startActivity(intent);
            }
        });
        // Blink Logout

        Button logOut = findViewById(R.id.outPublication);

        Animation animButton = new AlphaAnimation(0.0f, 1.0f);
        animButton.setDuration(100); //You can manage the blinking time with this parameter
        animButton.setStartOffset(20);
        animButton.setRepeatMode(Animation.REVERSE);
        animButton.setRepeatCount(Animation.INFINITE);
        logOut.startAnimation(animButton);

        // Return Button
        buttonReturn = findViewById(R.id.publicationToMainID);

        buttonReturn.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Publication.this, Award.class);
                startActivity(intent);

            }
        });

        // Setting ListView
        Resources res = getResources();

        String title[] = res.getStringArray(R.array.publicationTitle);
        String author[] = res.getStringArray(R.array.publicationAuthor);
        String type[] = res.getStringArray(R.array.publicationType);
        String location[] = res.getStringArray(R.array.publicationLocation);
        String date[] = res.getStringArray(R.array.publicationDate);
        String number[] = res.getStringArray(R.array.publicationNumber);
        String status[] = res.getStringArray(R.array.publicationStatus);


        publicationListView = findViewById(R.id.publicationListView);

        PublicationAdapter customAdapter = new PublicationAdapter(getApplicationContext(),type, title,author, location,  date,number,  status) ;
        publicationListView.setAdapter(customAdapter);

    }// End of onCreate

    @Override
    public void onBackPressed() { }
}
