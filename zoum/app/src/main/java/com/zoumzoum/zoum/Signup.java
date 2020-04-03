package com.zoumzoum.zoum;

import android.view.LayoutInflater;
import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Signup extends Activity
{

    public EditText Name;
    public EditText Password;
    public TextView Info;
    public Button Login;
    public int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Name = findViewById(R.id.username);
        Password = findViewById(R.id.password);
        Info = findViewById(R.id.info);
        Login = findViewById(R.id.logIn);

        Info.setText("No of attempts remaining: 5");

        Login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(), Password.getText().toString());
            }
        });
    }//End of onCreate

    public void validate(String userName, String userPassword)
    {
        if((userName.equals("ZOUMA")) && (userPassword.equals("adama")))
        {
            Intent intent = new Intent(Signup.this, MainActivity.class);
            startActivity(intent);
        }
        else
        {
            //Alert message
            LayoutInflater inflater = getLayoutInflater();
            View layout = inflater.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.custom_toast_container));

            TextView textToast = layout.findViewById(R.id.toastLogIn);
            textToast .setText("Wrong Input!");


            Toast toast = new Toast(getApplicationContext());
            toast.setGravity(Gravity.CENTER|Gravity.LEFT, 400, 300);
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.setView(layout);
            toast.show();
            counter--;

            Info.setText("No of attempts remaining: " + String.valueOf(counter));

            if(counter == 0){ Login.setEnabled(false); }
            RunAnimation();
        }
    }//End of validate
    //animation
    public void RunAnimation()
    {
        Animation a = AnimationUtils.loadAnimation(this, R.anim.sign_up_animation);
        a.reset();
        TextView tv = findViewById(R.id.info);
        tv.clearAnimation();
        tv.startAnimation(a);
    }//End of animation

    @Override
    public void onBackPressed()
    {
        // close app
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);
    }

}// End of Signup
