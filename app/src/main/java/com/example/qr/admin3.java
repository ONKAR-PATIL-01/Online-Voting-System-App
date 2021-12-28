package com.example.qr;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class admin3 extends AppCompatActivity {
    Button b3;
    ImageView i11;
    EditText t11;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin3);
        b3=findViewById(R.id.b1);
        t11= findViewById(R.id.t1);
        i11= findViewById(R.id.i1);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tt=t11.getText().toString();
                if(t11.getText()==null)
                {

                }
                else {
                    try
                    {
                        MultiFormatWriter m1=new MultiFormatWriter();
                        BitMatrix m2=m1.encode(tt, BarcodeFormat.QR_CODE,300,300);
                        BarcodeEncoder m3=new BarcodeEncoder();
                        Bitmap m4=m3.createBitmap(m2);
                        i11.setImageBitmap(m4);


                    }catch (Exception e){}
                }
            }
        });
    }



}
