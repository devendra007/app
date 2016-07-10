package com.example.shrinivas.login1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {


    EditText e1,e2;
    Button b1,b2;
    TextView t1,t2;
    dbhelper logindbhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=(EditText)findViewById(R.id.editText);
        e2=(EditText)findViewById(R.id.editText2);
        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);
        t1=(TextView)findViewById(R.id.textView);
        t2=(TextView)findViewById(R.id.textView2);
        logindbhelper=new dbhelper(this);
        logindbhelper = logindbhelper.open();


    }

    public void login(View view) {
        String struser,strpass,checkpassword;
        struser=e1.getText().toString();
        strpass=e2.getText().toString();
        checkpassword=logindbhelper.getSinlgeEntry(struser);
        if(strpass.equals(checkpassword))
            Toast.makeText(MainActivity.this,"LOGGED IN SUCCESSFULLY",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(MainActivity.this,"Incorrect username or Password",Toast.LENGTH_LONG).show();
    }
    public void signup (View view)
    {
        Intent intentsignup = new Intent("com.example.shrinivaas.login1.SIGNUP");
        startActivity(intentsignup);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();

        logindbhelper.close();
    }
}
