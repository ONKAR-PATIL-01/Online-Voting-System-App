package com.example.qr;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class result1 extends AppCompatActivity {
EditText m1,m2,m3,m4,m5;
member2 mm2;
    Intent i6;
DatabaseReference ref,ref1;
member1 m;

    String ss1,ss2,ss3,ss4,ss5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result1);
        m1=findViewById(R.id.t1);
        m2=findViewById(R.id.t2);
        m3=findViewById(R.id.t3);
        m4=findViewById(R.id.t4);
        m5=findViewById(R.id.t5);
loadData();
i6=getIntent();
        ref1=FirebaseDatabase.getInstance().getReference("member2");
        ref1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ds:dataSnapshot.getChildren())
                {
                    mm2=ds.getValue(member2.class);
                    m1.append("="+mm2.getL());
                    m2.append("="+mm2.getM());
                    m3.append("="+mm2.getO());
                    m4.append("="+mm2.getP());
                    m5.append("="+mm2.getQ());



                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
m=new member1();
ref= FirebaseDatabase.getInstance().getReference("member1");
ref.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        for(DataSnapshot ds:dataSnapshot.getChildren())
        {
            m=ds.getValue(member1.class);
           m1.append(""+m.getA());
            m2.append(""+m.getB());
            m3.append(""+m.getC());
            m4.append(""+m.getD());
            m5.append(""+m.getE());



        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
});

    }
    public void saveData()
    {
        SharedPreferences sp= getSharedPreferences("abc",MODE_PRIVATE);
        sp.edit().putString("a",  i6.getStringExtra("candidate1")).apply();
        sp.edit().putString("b",  i6.getStringExtra("candidate2")).apply();
        sp.edit().putString("c",  i6.getStringExtra("candidate3")).apply();
        sp.edit().putString("d",  i6.getStringExtra("candidate4")).apply();
        sp.edit().putString("e",  i6.getStringExtra("candidate5")).apply();



    }

    @Override
    protected void onPause() {
        super.onPause();
        saveData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadData();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
  loadData();
    }


    @Override
    protected void onStop() {
        super.onStop();
        saveData();
    }

    @Override
    protected void onStart() {
        super.onStart();
        loadData();
    }

    public void loadData()
    {
        SharedPreferences sp= getSharedPreferences("abc",MODE_PRIVATE);
        ss1=sp.getString("a","");
        ss2=sp.getString("b","");
        ss3=sp.getString("c","");
        ss4=sp.getString("d","");
        ss5=sp.getString("e","");
 /*mm2=new member2();
        DatabaseReference ref=FirebaseDatabase.getInstance().getReference("member2").child("1");
       *//* mm2.setL(ss1);
        mm2.setM(ss2);
        mm2.setO(ss3);
        mm2.setP(ss4);
        mm2.setQ(ss5);*//*
        HashMap h=new HashMap();
        h.put("l",ss1);
        h.put("m",ss2);
        h.put("o",ss3);
        h.put("p",ss4);
        h.put("q",ss5);
ref.updateChildren(h);
ref.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        for(DataSnapshot ds:dataSnapshot.getChildren())
        {
            mm2=ds.getValue(member2.class);
         m1.append(mm2.getL());
         m2.append(mm2.getM());
         m3.append(mm2.getO());
         m4.append(mm2.getP());
         m5.append(mm2.getQ());

        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
});*/

    }

}
