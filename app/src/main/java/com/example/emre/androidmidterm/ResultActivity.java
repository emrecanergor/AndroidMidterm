package com.example.emre.androidmidterm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    String isim ="";
    String ogrenci="";
    String Cinsiyet="";
    String Ders="";
    String Dil="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        isim = getIntent().getExtras().getString("isim");
        ogrenci = getIntent().getExtras().getString("ogrenci");
        Cinsiyet = getIntent().getExtras().getString("cinsiyet");
        Ders = getIntent().getExtras().getString("ders");
        Dil = getIntent().getExtras().getString("dil");

        ((TextView)findViewById(R.id.tvIsim)).setText(isim);
        ((TextView)findViewById(R.id.tvOgrenci)).setText(ogrenci);
        ((TextView)findViewById(R.id.tvCinsiyet)).setText(Cinsiyet);
        ((TextView)findViewById(R.id.tvDers)).setText(Ders);
        ((TextView)findViewById(R.id.tvDil)).setText(Dil);

    }


}
