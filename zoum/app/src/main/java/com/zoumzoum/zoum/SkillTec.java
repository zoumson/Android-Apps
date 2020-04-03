package com.zoumzoum.zoum;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;


public class SkillTec extends Activity
{
    Button buttonReturn, Logout;

    ListView skillTechnicalListView;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skill_tec);

        // Logout Button
        Logout = findViewById(R.id.outSkillTec);
        Logout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SkillTec.this, Signup.class);
                startActivity(intent);
            }
        });


        // Blink Logout

        Button logOut = findViewById(R.id.outSkillTec);

        Animation animButton = new AlphaAnimation(0.0f, 1.0f);
        animButton.setDuration(100); //You can manage the blinking time with this parameter
        animButton.setStartOffset(20);
        animButton.setRepeatMode(Animation.REVERSE);
        animButton.setRepeatCount(Animation.INFINITE);
        logOut.startAnimation(animButton);

        // Return Button
        buttonReturn = findViewById(R.id.technicalToSkillID);


        buttonReturn.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(SkillTec.this, Skills.class);
                startActivity(intent);

            }
        });

       // setting ListView
        Resources res = getResources();

        String title[] = res.getStringArray(R.array.skillTechnicalTitle);

        SkillTechnicalListItem[] skillTechnicalArray = new SkillTechnicalListItem[title.length];



        TypedArray ta = res.obtainTypedArray(R.array.skillTechnicalSubTitle);

        for (int i = 0; i < title.length; ++i)
        {
            int id = ta.getResourceId(i, 0);
            String[]subTitle = res.getStringArray(id);
            SkillTechnicalListItem item = new SkillTechnicalListItem(title[i],subTitle);
            skillTechnicalArray[i] = item;


        }
        ta.recycle(); // Important!


        skillTechnicalListView = findViewById(R.id.technicalSkillListView);
        SkillTechnicalAdapter adp = new SkillTechnicalAdapter(getApplicationContext(), skillTechnicalArray);
        skillTechnicalListView.setAdapter(adp);

    }// End of onCreate

    @Override
    public void onBackPressed() { }
}




