package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, onClick {
    TextView text1, text2, text3, text4;
    Button sum;
    EditText ed1, ed2, ed3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.sum = findViewById(R.id.sum);
        this.ed1 = findViewById(R.id.a);
        this.ed2 = findViewById(R.id.b);
        this.ed3 = findViewById(R.id.c);
        this.text1 = findViewById(R.id.textView1);
        this.text2 = findViewById(R.id.textView2);
        this.text3 = findViewById(R.id.textView3);
        this.text4 = findViewById(R.id.textView4);
        sum.setOnClickListener(this);
    }

    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    @Override
    public void onClick(View v) {
        String t1 = ed1.getText().toString();
        String t2 = ed2.getText().toString();
        String t3 = ed3.getText().toString();
        int a = Integer.parseInt(t1);
        int b = Integer.parseInt(t2);
        int c = Integer.parseInt(t3);
        if(a == 0){
            text1.setText("Error");
            text2.setText("Error");
            text3.setText("Error");
            text4.setText("Error");
        }
        double D = b*b - 4*a*c;
        if (D<0) {
            text1.setText("Error");
            text2.setText("Error");
            text3.setText("Error");
            text4.setText("Error");
        }
        if(D == 0){
            double x = (double) b /(-2*a);
            if (x<0){
                text1.setText("-");
                text2.setText("-");
                text3.setText(String.format("%f", x));
                text4.setText(String.format("%f", x));
            }
            if (x>=0) {
                text1.setText(String.format("%f", x));
                text2.setText(String.format("%f", x));
                text3.setText("-");
                text4.setText("-");
            }
        }
        if (D>0) {
            double x1, x2;
            x1 = (-b+Math.sqrt(D))/(2*a);
            x2 = (-b-Math.sqrt(D))/(2*a);
            if (x1<0&&x2<0){
                text1.setText("-");
                text2.setText("-");
                text3.setText(String.format("%f", x1));
                text4.setText(String.format("%f", x2));
            }
            if (x1<0&&x2>=0){
                text1.setText("-");
                text2.setText(String.format("%f", x2));
                text3.setText(String.format("%f", x1));
                text4.setText("-");
            }
            if (x1>=0&&x2<0){
                text1.setText(String.format("%f", x1));
                text2.setText("-");
                text3.setText("-");
                text4.setText(String.format("%f", x2));
            }
            if (x1>=0&&x2>=0) {
                text1.setText(String.format("%f", x1));
                text2.setText(String.format("%f", x2));
                text3.setText("-");
                text4.setText("-");
            }
        }
    }
}