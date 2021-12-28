package com.example.qr;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class admin2 extends AppCompatActivity {
EditText e1,e2,e3,e4;
Button b;
    DatabaseReference ref ;
    member m;
    long max=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin2);
        e1=findViewById(R.id.ee1);
        e2=findViewById(R.id.ee2);
        e3=findViewById(R.id.ee3);
        e4=findViewById(R.id.ee4);
        b=findViewById(R.id.ee5);
        ref= FirebaseDatabase.getInstance().getReference().child("member");
        m=new member();
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                {
                    max=(dataSnapshot.getChildrenCount());

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long ern=Long.parseLong(e3.getText().toString().trim());
m.setName(e1.getText().toString().trim());
m.setSur(e2.getText().toString().trim());
m.setEn(ern);
m.setP(e4.getText().toString().trim());
                ref.child(String.valueOf(max+1)).setValue(m);
                Toast.makeText(admin2.this, "Inserted Successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
