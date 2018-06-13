package com.example.shubham.quiz1;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
     Button b1,b2,b3,b4,b5;
     TextView t1,t2,t3,t4;
     int Count;
     int correctCount;
     ArrayList<Integer> answers;
     ArrayList<Integer> operations;
     int locationOfCorrectAnswers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         t1 = findViewById(R.id.textView2);
         t2 = findViewById(R.id.textView3);
         t3 = findViewById(R.id.textView4);
         t4 = findViewById(R.id.textView5);
         b2=findViewById(R.id.button8);
         b3=findViewById(R.id.button9);
         b4=findViewById(R.id.button10);
         b5=findViewById(R.id.button11);
         answers=new ArrayList<>();
         operations=new ArrayList<>();
         t3.setText(correctCount+"/"+Count);
         generateQuestion();


      //  new CountDownTimer(10000,1000)
        //{
//
  //          @Override
    //        public void onTick(long millisUntilFinished) {
      //          Log.i("Running","passed one second");
        //    }

      //      @Override
        //    public void onFinish() {
          //    Log.i("Finished","Passed 10 Seconds");
           // }
        //}.start();
        //final Handler handler = new Handler();
        //Runnable run = new Runnable() {
          //  @Override
            //public void run() {
              //  Log.i("Runnable has run!","a second passes"+Math.random());
              //  handler.postDelayed(this, 1000);
            //}
        //};
       //handler.post(run);

    }
    public void go(View view)
    {
        b1=findViewById(R.id.button);
        findViewById(R.id.group3).setVisibility(View.VISIBLE);
        b1.setVisibility(View.GONE);
        t4.setText("Welcome bro!");
        correctCount=0;
        Count=0;
        new CountDownTimer(30100,1000) {

            public void onTick(long millisUntilFinished) {
                Log.i("Running", "passed one Second");
                t1.setText(String.valueOf(millisUntilFinished/1000)+"s");
            }

            @Override
            public void onFinish() {
                Log.i("Finished", "Passed 30 Seconds");
                t1.setText("Finish!");
                Toast.makeText(getApplicationContext(),"Game Finished",Toast.LENGTH_LONG).show();
                findViewById(R.id.group3).setVisibility(View.GONE);
                b1.setVisibility(View.VISIBLE);
            }
        }.start();


    }
    String operator;
    public void generateQuestion()
    {
        answers.clear();
        Random random = new Random();
        int a= random.nextInt(1000);
        int b=random.nextInt(1000);
       // int operation=random.nextInt(4);
        t2.setText(a+"+"+b+"=?");
       // switch (operation)
        //{
          //  case 0: operator ="+";
            //    t2.setText(a+"+"+b+"=?");
              //  break;
      //case 1: operator ="-";
        //        t2.setText(a+"-"+b+"=?");
          //      break;
            //case 2: operator ="*";
              //  t2.setText(a+"*"+b+"=?");
                //break;
         //   case 3: operator ="/";
           //     t2.setText(a+"/"+b+"=?");
             //   break;

        //}
        locationOfCorrectAnswers=random.nextInt(4);
        int incorrectAnswer;
        for(int i=0;i<4;i++)
        {
            if(locationOfCorrectAnswers==i)
            {
              //  if()
                //{
                    answers.add(a + b);
                //}
            }
            else
            {
                incorrectAnswer=random.nextInt(2000);
                while (incorrectAnswer==a+b)
                {
                    incorrectAnswer=random.nextInt(2000);
                }
                answers.add(incorrectAnswer);
            }
        }
        b2.setText(answers.get(0)+"");
        b3.setText(answers.get(1)+"");
        b4.setText(answers.get(2)+"");
        b5.setText(answers.get(3)+"");

        }

    public void click(View view) {
        Button btn = (Button) view;
        if (btn.getTag().toString().equals(locationOfCorrectAnswers + "")) {
            t4.setText("Correct");
        } else {
            t4.setText("Incorrect");
        }
        Count++;
        if(btn.getTag().toString().equals(locationOfCorrectAnswers+""))
        {
            correctCount++;
            t3.setText(correctCount+"/"+Count);
        }
        else
        {
            t3.setText(correctCount+"/"+Count);
        }
        generateQuestion();
    }
    //public void count()
    //{
    // t3.setText(Count);
      //  Count++;
    //}

}
