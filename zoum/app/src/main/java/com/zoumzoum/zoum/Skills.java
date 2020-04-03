package com.zoumzoum.zoum;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.Button;
import android.os.Bundle;
import android.widget.ListView;

public class Skills extends Activity
{
    Button buttonReturn, Logout;
    ListView skillListView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_skills);

        // Logout Button
        Logout = findViewById(R.id.outSkills);
        Logout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Skills.this, Signup.class);
                startActivity(intent);
            }
        });

        // Blink Logout Button

        Button logOut = findViewById(R.id.outSkills);

        Animation animButton = new AlphaAnimation(0.0f, 1.0f);
        animButton.setDuration(100); //You can manage the blinking time with this parameter
        animButton.setStartOffset(20);
        animButton.setRepeatMode(Animation.REVERSE);
        animButton.setRepeatCount(Animation.INFINITE);
        logOut.startAnimation(animButton);

        // Return Button
        buttonReturn = findViewById(R.id.skillToMenuID);


        buttonReturn.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Skills.this, MainActivity.class);
                startActivity(intent);

            }
        });

        // Setting ListView
        Resources res = getResources();

        String skills[] = res.getStringArray(R.array.skillItem);

        // Getting logo from drawable
        TypedArray tArray = getResources().obtainTypedArray(R.array.skillLogo);

        int[] logos = new int[skills.length];

        for (int i = 0; i < logos.length; i++) logos[i] = tArray.getResourceId(i, 0);
        tArray.recycle();



        skillListView = findViewById(R.id.skillListView);

        CustomAdapter adp = new CustomAdapter(getApplicationContext(), skills, logos);
        skillListView.setAdapter(adp);


        skillListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                switch( position )
                {
                    case 0:  Intent newActivity1 = new Intent(getApplicationContext(), SkillTec.class);
                        startActivity(newActivity1);
                        break;
                    case 1:  Intent newActivity2 = new Intent(getApplicationContext(), SkillProg.class);
                        startActivity(newActivity2);
                        break;
                    case 2:  Intent newActivity3 = new Intent(getApplicationContext(), SkillLang.class);
                        startActivity(newActivity3);
                        break;
                    case 3:  Intent newActivity4 = new Intent(getApplicationContext(), SkillSoft.class);
                        startActivity(newActivity4);
                        break;

                }


            }
        });// End of skillListView click event
    }// End of onCreate

    @Override
    public void onBackPressed() { }
}
