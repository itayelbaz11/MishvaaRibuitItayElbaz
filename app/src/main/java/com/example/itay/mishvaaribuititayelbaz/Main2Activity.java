package com.example.itay.mishvaaribuititayelbaz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    WebView wv;
    String st,stback;
    TextView tvX,tvX2;
    double aa,b,c,x1,x2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        wv=(WebView) findViewById(R.id.wv);
        tvX=(TextView) findViewById(R.id.tvX);
        tvX2=(TextView) findViewById(R.id.tvX2);

        wv.getSettings().setJavaScriptEnabled(true);

        st="https://www.google.com/search?ei=DXVCXKS6LbHrxgPV-YGYDw&q=";
        Intent gi=getIntent();
        aa=gi.getDoubleExtra("a",0);
        b=gi.getDoubleExtra("b",0);
        c=gi.getDoubleExtra("c",0);
        st=st+aa+"x%5E2"+b+"x%2B"+c+"&oq";
        wv.loadUrl(st);
        if(Math.sqrt(b*b-4*aa*c)>=0) {
            if(Math.sqrt(b*b-4*aa*c)==0) {
               x1=(-b+Math.sqrt(b*b-4*aa*c))/(2*aa);
               tvX.setText("x1="+x1);
               tvX2.setText("");
               stback=tvX.getText().toString()+tvX2.getText().toString();
            }
            else {
                x1=(-b+Math.sqrt(b*b-4*aa*c))/(2*aa);
                tvX.setText("x1="+x1);
                x2=(-b-Math.sqrt(b*b-4*aa*c))/(2*aa);
                tvX2.setText("x2="+x2);
                stback=tvX.getText().toString()+tvX2.getText().toString();
            }
            }

        else {
            tvX.setText("there are no solutions");
            tvX2.setText("");
            stback=tvX.getText().toString()+tvX2.getText().toString();
        }
    }


    public void back(View view) {
        Intent si= new Intent(this,MainActivity.class);
        si.putExtra("st",stback);
        startActivity(si);
    }
}




