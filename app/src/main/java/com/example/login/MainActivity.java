package com.example.login;

import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity  {
    String[] languages = { "English", "Tamil", "French", "Japanese"};
    EditText input_password;
    ImageView show_hide_pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spin = findViewById(R.id.spinner);
        input_password = findViewById(R.id.input_pass);
        show_hide_pwd = findViewById(R.id.show_hide_password);

        show_hide_pwd.setImageResource(R.drawable.ic_hide_pwd);
        show_hide_pwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input_password.getTransformationMethod().equals(HideReturnsTransformationMethod.getInstance())){
                //If password is visible then  Hide it
                input_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                //change icon
                    show_hide_pwd.setImageResource(R.drawable.ic_hide_pwd);
                } else {
                    input_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    show_hide_pwd.setImageResource(R.drawable.ic_show_pwd);
                }
            }
        });




        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item, languages);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);

    }



}