package com.zoumzoum.zoum;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.os.Bundle;
import android.widget.TextView;

public class Career extends Activity
{
    Button buttonReturn, Logout;

    TextView careerContent;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_career);
        Resources res = getResources();

        // Career content
        careerContent = findViewById(R.id.careerContent);


        String careerContentString = res.getString(R.string.careerObjective);
        careerContent.setText(careerContentString);
       // Logout Button
        Logout = findViewById(R.id.outCareer);

        // Logout click event
        Logout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(Career.this, Signup.class);
                startActivity(intent);
            }
        });

        // Blink Logout

        Button logOut = findViewById(R.id.outCareer);

        Animation animButton = new AlphaAnimation(0.0f, 1.0f);
        animButton.setDuration(100); //You can manage the blinking time with this parameter
        animButton.setStartOffset(20);
        animButton.setRepeatMode(Animation.REVERSE);
        animButton.setRepeatCount(Animation.INFINITE);

        logOut.startAnimation(animButton);
        // Return Button
        buttonReturn = findViewById(R.id.careerToMenuID);


        buttonReturn.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Career.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }// End of onCreate

    @Override
    public void onBackPressed() { }
}

