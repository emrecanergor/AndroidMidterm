package com.example.emre.androidmidterm;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.InvocationTargetException;


public class MainActivity extends Activity {

    String isim ="";
    String ogrenci="";
    String Cinsiyet="";
    String Ders="";
    String Dil="";

    CheckBox cb;
    Button btn;
    RadioGroup rgbCins;
    RadioGroup rgbDers;
    RadioButton rbCinsiyet;
    RadioButton rbDers;

    EditText et;

    Context context = this;

    boolean ogrenciDegisken = true;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cb = findViewById(R.id.checkBox);
        btn = findViewById(R.id.button);
        et = findViewById(R.id.editText);
        rgbCins = findViewById(R.id.rgbCins);
        rgbDers = findViewById(R.id.rgbDers);

        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(ogrenciDegisken) {
                    ogrenci = "Evet";
                    ogrenciDegisken = false;
                }
                else{
                    ogrenci = "Hayır";
                    ogrenciDegisken = true;
                }
            }
        });



        btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                rbCinsiyet = (RadioButton)findViewById(rgbCins.getCheckedRadioButtonId());
                Cinsiyet = rbCinsiyet.getText().toString();

                rbDers = (RadioButton)findViewById(rgbDers.getCheckedRadioButtonId());
                Ders = rbDers.getText().toString();

                isim = ((EditText)findViewById(R.id.editText)).getText().toString();


                if(fieldControl()) {

                    try{

                    AlertDialog.Builder uyari = new AlertDialog.Builder(context);
                    uyari.setTitle("Kritik Soru");
                    uyari.setMessage("Java mı C# mı");
                    uyari.setCancelable(false);

                    uyari.setPositiveButton("Java", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            Dil = "Java";

                            activityStartFunc();

                        }
                    });

                    uyari.setNegativeButton("C#", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            Dil = "C#";

                            activityStartFunc();
                        }
                    });

                    AlertDialog alertDialog = uyari.create();
                    alertDialog.show();

                }
                //catch(InvocationTargetException e)
                //{
                    //   e.getCause().printStackTrace();
                //}
                catch (Exception ex)
                {
                    ex.printStackTrace();
                }


                }
            }
        });


    }

    private boolean fieldControl()
    {
        if (et.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "ADINIZI GİRİNİZ",
                    Toast.LENGTH_SHORT);
        }
        else if (ogrenci.equals("")) {

            Toast.makeText(getApplicationContext(), "OGRENCI ALANINI SEÇİNİZ",
                    Toast.LENGTH_SHORT);
        }
        else if (Cinsiyet.equals("")) {

            Toast.makeText(getApplicationContext(), "CİNSİYET ALANINI SEÇİNİZ",
                    Toast.LENGTH_SHORT);
        }
        else if (Ders.equals("")) {

            Toast.makeText(getApplicationContext(), "CİNSİYET ALANINI SEÇİNİZ",
                    Toast.LENGTH_SHORT);
        }
        else{
            return true;
        }


        return false;
    }


    private void activityStartFunc()
    {
        Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
        intent.putExtra("isim", isim);
        intent.putExtra("ogrenci", ogrenci);
        intent.putExtra("cinsiyet", Cinsiyet);
        intent.putExtra("ders", Ders);
        intent.putExtra("dil", Dil);
        startActivity(intent);
    }


}
