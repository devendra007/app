package com.example.shrinivas.login1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Shrinivas on 10-07-2016.
 */
public class signup extends Activity {
    EditText e3, e4, e5,e6;
    TextView t3, t4, t5,t6;
    Button b3;
    dbhelper signupdbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e3 = (EditText) findViewById(R.id.editText3);
        e4 = (EditText) findViewById(R.id.editText4);
        e5 = (EditText) findViewById(R.id.editText5);
        e6 = (EditText)findViewById(R.id.editText6);
        b3 = (Button) findViewById(R.id.button3);
        t3 = (TextView) findViewById(R.id.textView3);
        t4 = (TextView) findViewById(R.id.textView4);
        t5 = (TextView) findViewById(R.id.textView5);
        t6 = (TextView) findViewById(R.id.textView6);
        signupdbhelper=new dbhelper(this);
        signupdbhelper=signupdbhelper.open();

    }

    public void submit(View view) {
        String strname,struser1,strpass1,strcnfpass;
        strname=e3.getText().toString();
        struser1=e4.getText().toString();
        strpass1=e5.getText().toString();
        strcnfpass=e6.getText().toString();
        if(strname.equals(""))
        {
            Toast.makeText(getApplicationContext(),"please enter the Name",Toast.LENGTH_LONG).show();
        }
        else if(struser1.equals(""))
        {
            Toast.makeText(getApplicationContext(),"please enter the UserName",Toast.LENGTH_LONG).show();
        }
        else if(strpass1.equals(""))
        {
            Toast.makeText(getApplicationContext(),"please enter the Password",Toast.LENGTH_LONG).show();
        }
        else if(strcnfpass.equals(""))
        {
            Toast.makeText(getApplicationContext(),"please enter the ConfirmPassword",Toast.LENGTH_LONG).show();
        }
        if(!strpass1.equals(strcnfpass))
        {
            Toast.makeText(getApplicationContext(),"Password does not match",Toast.LENGTH_LONG).show();
        }
        else
        {
            signupdbhelper.insert(strname,struser1,strpass1);
            Toast.makeText(getApplicationContext(),"Account created successfully",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        signupdbhelper.close();
    }
}

