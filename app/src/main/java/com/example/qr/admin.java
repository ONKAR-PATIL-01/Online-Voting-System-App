package com.example.qr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.qr.R.layout.activity_admin;

public class admin extends AppCompatActivity {
Button b11;
EditText et1,et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_admin);
        b11=findViewById(R.id.login);
        et1=findViewById(R.id.username);
        et2=findViewById(R.id.password);

        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et1.getText().toString().equals("chess")&&et2.getText().toString().equals("checkmate"))
                {
                    Intent i5= new Intent(getApplicationContext(),admin1.class);
                    startActivity(i5);
                }
            }
        });
    }

}
