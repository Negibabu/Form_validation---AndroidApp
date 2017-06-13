package com.wordpress.sreeharilive.form;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.R.attr.id;

public class MainActivity extends AppCompatActivity {
    Button btn;
    String n,m,e,a;
    EditText editText,editText2,editText3,editText4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button)findViewById(R.id.button);
        editText = (EditText)findViewById(R.id.editText);
        editText2 = (EditText)findViewById(R.id.editText2);
        editText3 = (EditText)findViewById(R.id.editText3);
        editText4 = (EditText)findViewById(R.id.editText4);

    }
    public void submitform(View v){
        n=editText.getText().toString();
        m=editText3.getText().toString();
        e=editText4.getText().toString();
        a=editText2.getText().toString();
        String regx = "[a-zA-Z]*";
        String regy = "[0-9]*";
        String rez = "[a-z][a-z0-9_-]+@[a-z]+\\.com";
        if(n.matches("") || m.matches("") || e.matches("") ||a.matches(""))
            Toast.makeText(this,"Some fields are empty",Toast.LENGTH_SHORT).show();
        else
        {
            if (!e.matches(rez))
                Toast.makeText(this, "Invalid email id", Toast.LENGTH_SHORT).show();
            if (!(n.charAt(0) >= 'A' && n.charAt(0) <= 'Z') || !n.matches(regx))
                Toast.makeText(this, "Invalid Name", Toast.LENGTH_SHORT).show();
            if (m.length() != 10 || !m.matches(regy))
                Toast.makeText(this,"Invalid Mobile number",Toast.LENGTH_SHORT).show();
            if(e.matches(rez) && (n.charAt(0) >= 'A' && n.charAt(0) <= 'Z') && n.matches(regx) && m.length() == 10 && m.matches(regy))
                Toast.makeText(this,"Form submitted successfully",Toast.LENGTH_SHORT).show();
        }
    }
}
