package com.example.itay.mishvaaribuititayelbaz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText et1,et2,et3;
    TextView tv,tv2;
    String st;
    double aa,b,c,x;
    boolean bo=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1=(EditText) findViewById(R.id.et1);
        et2=(EditText) findViewById(R.id.et2);
        et3=(EditText) findViewById(R.id.et3);
        tv=(TextView) findViewById(R.id.tv);
        tv2=(TextView) findViewById(R.id.tv2);

        Intent gi=getIntent();
        tv.setText("last answers: "+gi.getStringExtra("st"));
        if(gi.getStringExtra("st")==null) {
           tv.setText("last answers:");
        }
        }


    public void answer(View view) {
        bo=true;
        st=et1.getText().toString();
        if(st.length()==0) {
           bo=false;
        }
         else {
            aa = Double.parseDouble(st);
        }
        st=et2.getText().toString();
        if(st.length()==0) {
            bo=false;
        }
          else {
            b = Double.parseDouble(st);
        }
        st=et3.getText().toString();
        if(st.length()==0) {
            bo=false;
        }
          else {
            c = Double.parseDouble(st);
        }
        if(bo) {
             Intent si=new Intent(this,Main2Activity.class);
             si.putExtra("a",aa);
             si.putExtra("b",b);
             si.putExtra("c",c);
             startActivity(si);

        }
           else {
             tv2.setText("try again...");

        }

    }

    public void clear(View view) {
        et1.setText("");
        et2.setText("");
        et3.setText("");
        tv2.setText("");
    }

    public void random(View view) {
        aa=Math.random()*100;
        x=Math.random();
        if(x<0.5) {
          aa=0-aa;
        }
        et1.setText(""+aa);
        b=Math.random()*100;
        x=Math.random();
        if(x<0.5) {
            b=0-b;
        }
        et2.setText(""+b);
        c=Math.random()*100;
        x=Math.random();
        if(x<0.5) {
            c=0-c;
        }
        et3.setText(""+c);
    }
}
