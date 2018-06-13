package com.example.shubham.calculator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    int a, b;
    String op;
    TextView tv,tv2;
    Boolean isOperatorPressed=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.textView);
        tv2 = findViewById(R.id.textView2);
    }
    public void appendTv2(String s){

        tv2.setText(tv2.getText().toString()+s);
    }

    public void numberClick(View view) {
        Button btn = (Button) view;
        if (isOperatorPressed) {
            clearText();
            isOperatorPressed=false;
        }
        String s = btn.getTag().toString();
        tv.setText(tv.getText().toString() + s);
    }

    public void clearNumber(View view) {
        clearText();
        tv2.setText("");
    }
    public void findOp(View view) {
        Button opBtn = (Button) view;
        op = opBtn.getText().toString();
        a = Integer.parseInt(tv.getText().toString());
        appendTv2(a+"");
        appendTv2(op);
        isOperatorPressed = true;
    }
    public void clearText() {
        tv.setText("");
    }

    public void doOperation(View view) {
        String t = tv.getText().toString();
        if (!t.equals("")) {
            b = Integer.parseInt(t);
            int c=Integer.parseInt(t);
            switch (op) {
                case "+":
                    tv.setText((a+b) + "");
                    break;
                case "-":
                    tv.setText((a-b) + "");
                    break;
                case "*":
                    tv.setText((a*b) + "");
                    break;
                case "/":
                    tv.setText((a/b) + "");
                    break;
            }
                a=b;
                b=c;
                tv2.setText("");

        }
    }


    }


