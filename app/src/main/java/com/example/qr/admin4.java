package com.example.qr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.qr.R.id.bbbb;

public class admin4 extends AppCompatActivity {
Button bb;
EditText et1,et2,et3,et4,et5;
String s1,s2,s3,s4,s5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin4);
        bb= findViewById(bbbb);
        et1=findViewById(R.id.t1);
        et2=findViewById(R.id.t2);
        et3=findViewById(R.id.t3);
        et4=findViewById(R.id.t4);
         et5=findViewById(R.id.t5);
loadData();

bb.setOnClickListener(new View.OnClickListener() {

    @Override
    public void onClick(View v) {
        s1=et1.getText().toString();
        s2=et2.getText().toString();
        s3=et3.getText().toString();
        s4=et4.getText().toString();
        s5=et5.getText().toString();
        Intent i6 = new Intent(getBaseContext(), result1.class);
        i6.putExtra("candidate1",s1);
        i6.putExtra("candidate2",s2);
        i6.putExtra("candidate3",s3);
        i6.putExtra("candidate4",s4);
        i6.putExtra("candidate5",s5);
        startActivity(i6);


    }
});

    }
    public void saveData()
    {
        SharedPreferences sp= getSharedPreferences("abc",MODE_PRIVATE);
        sp.edit().putString("a", et1.getText().toString()).commit();
        sp.edit().putString("b", et2.getText().toString()).commit();
        sp.edit().putString("c", et3.getText().toString()).commit();
        sp.edit().putString("d", et4.getText().toString()).commit();
        sp.edit().putString("e", et5.getText().toString()).commit();

    }

    @Override
    protected void onPause() {
        super.onPause();
        saveData();
    }

    @Override
    protected void onStop() {
        super.onStop();
      saveData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadData();
    }

    public void loadData()
    {
        SharedPreferences sp= getSharedPreferences("abc",MODE_PRIVATE);
        s1=sp.getString("a","");
        s2=sp.getString("b","");
        s3=sp.getString("c","");
        s4=sp.getString("d","");
        s5=sp.getString("e","");
        et1.setText(s1);
        et2.setText(s2);
        et3.setText(s3);
        et4.setText(s4);
        et5.setText(s5);
    }
}
