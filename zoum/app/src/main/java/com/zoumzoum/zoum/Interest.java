package com.zoumzoum.zoum;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.os.Bundle;
import android.widget.GridView;

public class Interest extends Activity
{

    GridView interestGridView;
    Button buttonReturn, Logout;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interest);

        // Logout Button
        Logout = findViewById(R.id.outInterest);
        Logout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Interest.this, Signup.class);
                startActivity(intent);
            }
        });

        // Blink Logout

        Button logOut = findViewById(R.id.outInterest);

        Animation animButton = new AlphaAnimation(0.0f, 1.0f);
        animButton.setDuration(100); //You can manage the blinking time with this parameter
        animButton.setStartOffset(20);
        animButton.setRepeatMode(Animation.REVERSE);
        animButton.setRepeatCount(Animation.INFINITE);
        logOut.startAnimation(animButton);

        // Return Button
        buttonReturn = findViewById(R.id.interestToMenuID);


        buttonReturn.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Interest.this, MainActivity.class);
                startActivity(intent);

            }
        });


        // Setting ListView
        Resources res = getResources();

        String item[] = res.getStringArray(R.array.interestItem);

        interestGridView = findViewById(R.id.interestGridView); // init GridView
        // Create an object of CustomAdapter and set Adapter to GirdView
        InterestGridAdapter adp = new InterestGridAdapter(getApplicationContext(), item);
        interestGridView.setAdapter(adp);

    }// End of onCreate

    @Override
    public void onBackPressed() { }
}
