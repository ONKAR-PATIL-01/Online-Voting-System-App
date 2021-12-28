package com.example.qr;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class user_login extends AppCompatActivity {
EditText b3,b4;
Button l2;
DatabaseReference ref;
member m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        l2=findViewById(R.id.login1);
        b3=findViewById(R.id.u1);
        b4=findViewById(R.id.p1);
        ref= FirebaseDatabase.getInstance().getReference("member");
        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for(DataSnapshot ds:dataSnapshot.getChildren())
                        {
                                m=ds.getValue(member.class);
                            assert m != null;
                            String s= String.valueOf(m.getEn());
                                String ss=m.getP();
                            Toast.makeText(user_login.this, ""+s+""+ss, Toast.LENGTH_SHORT).show();
                            if(b3.getText().toString().equalsIgnoreCase(s) &&b4.getText().toString().equalsIgnoreCase(ss))

                            {
                                Intent i6= new Intent(getApplicationContext(),user1.class);
                                startActivity(i6);
                                 break;

                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });
    }
}
