package com.example.qr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class admin1 extends AppCompatActivity {
Button b111,b222,b333,b444;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin1);
        b111=findViewById(R.id.bb1);
        b222=findViewById(R.id.bb2);
        b333=findViewById(R.id.bb3);
        b444=findViewById(R.id.bb4);
        b111.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
Intent i=new Intent(getApplicationContext(),admin2.class);
startActivity(i);
            }
        });
        b222.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),admin3.class);
                startActivity(i);
            }
        });
        b333.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),admin4.class);
                startActivity(i);
            }
        });
        b444.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i6 = new Intent(getBaseContext(), result1.class);
                startActivity(i6);

            }
        });
    }
}
