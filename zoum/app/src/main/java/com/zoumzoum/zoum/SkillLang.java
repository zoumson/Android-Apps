package com.zoumzoum.zoum;


import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ListView;
import android.widget.Button;

public class SkillLang extends Activity
{
    Button buttonReturn, Logout;
    ListView skillSpokenLanguageListView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skill_lang);

        // Logout Button
        Logout = findViewById(R.id.outSkillLang);
        Logout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SkillLang.this, Signup.class);
                startActivity(intent);
            }
        });

        // Blink Logout Button

        Button logOut = findViewById(R.id.outSkillLang);

        Animation animButton = new AlphaAnimation(0.0f, 1.0f);
        animButton.setDuration(100); //You can manage the blinking time with this parameter
        animButton.setStartOffset(20);
        animButton.setRepeatMode(Animation.REVERSE);
        animButton.setRepeatCount(Animation.INFINITE);
        logOut.startAnimation(animButton);

        // Return Button
        buttonReturn = findViewById(R.id.langSpToSkillID);


        buttonReturn.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(SkillLang.this, Skills.class);
                startActivity(intent);

            }
        });


        // Setting ListView
        Resources res = getResources();

        String skill[] = res.getStringArray(R.array.skillSpokenLanguageItem);
        int bar[] = res.getIntArray(R.array.skillSpokenLanguageProgressBar);


        // Getting logo from drawable
        TypedArray tArray = getResources().obtainTypedArray(R.array.skillSpokenLanguageLogo);

        int[] logos = new int[skill.length];

        for (int i = 0; i < logos.length; i++) logos[i] = tArray.getResourceId(i, 0);
        tArray.recycle();

        skillSpokenLanguageListView = findViewById(R.id.skillSpokenLanguageListView);
        SkillProgramAdapter adp = new SkillProgramAdapter(getApplicationContext(), skill, logos, bar);
        skillSpokenLanguageListView.setAdapter(adp);
    }// End of onCreate

    @Override
    public void onBackPressed() { }
}
