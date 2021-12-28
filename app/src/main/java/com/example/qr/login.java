package com.example.qr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class login extends AppCompatActivity {
RadioGroup rg;
RadioButton b1,b2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
rg=findViewById(R.id.rg);
b1=findViewById(R.id.b1);
b2=findViewById(R.id.b2);
b1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i1 = new Intent(getApplicationContext(), admin.class);
        startActivity(i1);

    }
});
b2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i2=new Intent(getApplicationContext(),user_login.class);
        startActivity(i2);
    }
});
    }
}
