package com.zoumzoum.zoum;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.GridView;
import android.widget.Button;

public class SkillSoft extends Activity
{
    Button buttonReturn, Logout;
    GridView skillSoftGridView;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skill_soft);

        // Logout Button
        Logout = findViewById(R.id.outSkillSoft);
        Logout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SkillSoft.this, Signup.class);
                startActivity(intent);
            }
        });



        // Blink Logout

        Button logOut = findViewById(R.id.outSkillSoft);

        Animation animButton = new AlphaAnimation(0.0f, 1.0f);
        animButton.setDuration(100); //You can manage the blinking time with this parameter
        animButton.setStartOffset(20);
        animButton.setRepeatMode(Animation.REVERSE);
        animButton.setRepeatCount(Animation.INFINITE);
        logOut.startAnimation(animButton);

        //Return Button
        buttonReturn = findViewById(R.id.softToSkillID);


        buttonReturn.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(SkillSoft.this, Skills.class);
                startActivity(intent);

            }
        });

        // Set GridView
        String skillSoftItems[] = getResources().getStringArray(R.array.skillSoft);
        skillSoftGridView = findViewById(R.id.skillSoftGridView); // init GridView
        // Create an object of CustomAdapter and set Adapter to GirdView
        GridCustomAdapter adp = new GridCustomAdapter(getApplicationContext(), skillSoftItems);
        skillSoftGridView.setAdapter(adp);

    }// End of onCreate

    @Override
    public void onBackPressed() { }
}
