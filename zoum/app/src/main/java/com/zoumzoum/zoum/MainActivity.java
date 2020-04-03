package com.zoumzoum.zoum;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity
{

    ListView menuListView;
    private Button Logout;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Logout = findViewById(R.id.outCV);
        Logout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Signup.class);
                startActivity(intent);
            }
        });

        // Blink software engineer

        final TextView myText = findViewById(R.id.myPosition);

        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(100); //You can manage the blinking time with this parameter
        anim.setStartOffset(20);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(10);
        myText.startAnimation(anim);

        myText.setBackgroundDrawable(getResources().getDrawable(R.drawable.back_change_on_click));
        myText.setOnClickListener(new View.OnClickListener()
        {
            //TextView myText = findViewById(R.id.myPosition);
            @Override
            public void onClick(View view)
            {
                // Blink software engineer

                //myText.setBackgroundColor(getResources().getColor(R.color.yellow));
               // myText.setTextColor(getResources().getColor(R.color.black));
                Animation anim = new AlphaAnimation(0.0f, 1.0f);
                anim.setDuration(100); //You can manage the blinking time with this parameter
                anim.setStartOffset(20);
                anim.setRepeatMode(Animation.REVERSE);
                anim.setRepeatCount(10);
                myText.startAnimation(anim);

            }


        });

        // Blink Logout

        Button logOut = findViewById(R.id.outCV);

        Animation animButton = new AlphaAnimation(0.0f, 1.0f);
        animButton.setDuration(100); //You can manage the blinking time with this parameter
        animButton.setStartOffset(20);
        animButton.setRepeatMode(Animation.REVERSE);
        animButton.setRepeatCount(Animation.INFINITE);
        logOut.startAnimation(animButton);

        // Setting ListView
        Resources res = getResources();

        String menuItem[] = res.getStringArray(R.array.menuItem);


        // Getting logo from drawable
        TypedArray tArray = getResources().obtainTypedArray(R.array.menuLogo);

        int[] logos = new int[menuItem.length];

        for (int i = 0; i < logos.length; i++) logos[i] = tArray.getResourceId(i, 0);
        tArray.recycle();

        menuListView = findViewById(R.id.menuListView);
        CustomAdapter adp = new CustomAdapter(getApplicationContext(), menuItem, logos);
        menuListView.setAdapter(adp);






        menuListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                switch( position )
                {
                    case 0:  Intent newActivity1 = new Intent(getApplicationContext(), Personal.class);
                        startActivity(newActivity1);
                        break;
                    case 1:  Intent newActivity2 = new Intent(getApplicationContext(), Career.class);
                        startActivity(newActivity2);
                        break;
                    case 2:  Intent newActivity3 = new Intent(getApplicationContext(), Education.class);
                        startActivity(newActivity3);
                        break;
                    case 3:  Intent newActivity4 = new Intent(getApplicationContext(), Skills.class);
                        startActivity(newActivity4);
                        break;
                    case 4:  Intent newActivity5 = new Intent(getApplicationContext(), Work.class);
                        startActivity(newActivity5);
                        break;
                    case 5:  Intent newActivity6 = new Intent(getApplicationContext(), Award.class);
                        startActivity(newActivity6);
                        break;

                    case 6:  Intent newActivity7 = new Intent(getApplicationContext(), Interest.class);
                        startActivity(newActivity7);
                        break;
                }


            }
        });// End of menuListView click event



    }// End of onCreate

    @Override
    public void onBackPressed() { }
}