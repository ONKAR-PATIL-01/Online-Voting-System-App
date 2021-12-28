package com.example.qr;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.HashMap;
import java.util.Map;

public class user1 extends AppCompatActivity {
    Button b1, b2;
    int i;
    long  j = 0, k = 0, l = 0, m = 0, n = 0;

HashMap h;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        final IntentResult ir = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        Toast.makeText(this, ir.getContents(), Toast.LENGTH_LONG).show();
       i = Integer.parseInt(String.valueOf(ir.getContents().charAt(0)));
        if (i == 1) {
            j++;
            Toast.makeText(this, " am In", Toast.LENGTH_SHORT).show();
        }
        if (i == 2) {

            k++;

        }
        if (i == 3) {
            l++;

        }
        if (i == 4) {
            m++;
        }
        if (i == 5) {
            n++;
        }
        DatabaseReference ref=FirebaseDatabase.getInstance().getReference("member1").child("1");
        h=new HashMap();
        h.put("a",j);
        h.put("b",k);
        h.put("c",l);
        h.put("d",m);
        h.put("e",n);

        ref.updateChildren(h);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user1);
        b2 = findViewById(R.id.user);
        b1 = findViewById(R.id.r);
      /*  DatabaseReference ref=FirebaseDatabase.getInstance().getReference("member1").child("1");
        h=new HashMap();
        h.put("a",j);
        h.put("b",k);
        h.put("c",l);
        h.put("d",m);
        h.put("e",n);

        ref.updateChildren(h);*/


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), result1.class));
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator ii = new IntentIntegrator(user1.this);
                ii.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                ii.setCameraId(0);
                ii.setOrientationLocked(false);
                ii.setPrompt("Scanning");
                ii.setBeepEnabled(true);
                ii.setBarcodeImageEnabled(true);
                ii.initiateScan();
            }
        });


    }

}
