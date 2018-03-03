package com.beginner.braintrainer;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button go;
    TextView pointstextview;
    TextView sumTextview;
    TextView timertextview;
    TextView correct;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button playagain;
    RelativeLayout gameRelativeLayout;

    ArrayList<Integer> answers=new ArrayList<Integer>();
    int locationofcorrectanswer;
    int scores=0;
    int numberofquestions=0;
    public void playagain(View view){
         scores=0;
        numberofquestions=0;
        timertextview.setText("30s");
        pointstextview.setText("0/0");
        correct.setText("");
        playagain.setVisibility(View.INVISIBLE);



        newquestion();
        new CountDownTimer(30100, 1000) {

        @Override
        public void onTick(long millisUntilFinished) {
            timertextview.setText(String.valueOf(millisUntilFinished / 1000) + "s");

        }

        @Override
        public void onFinish() {
            timertextview.setText("0s");
            correct.setText("Time's up Score:"+Integer.toString(scores)+"/"+Integer.toString(numberofquestions));

            playagain.setVisibility(View.VISIBLE);

        }
    }.start();


    }


    public void newquestion(){
        Random random=new Random();
        int a=random.nextInt(21);
        int b=random.nextInt(21);
        sumTextview.setText(Integer.toString(a)+"+"+Integer.toString(b));
        locationofcorrectanswer=random.nextInt(4);

        answers.clear();
        int incorrectanswer;
        for(int i=0;i<4;i++){
            if(locationofcorrectanswer==i){
                answers.add(a+b);
            }
            else{
                incorrectanswer=random.nextInt(41);
                while(incorrectanswer==a+b){
                    incorrectanswer=random.nextInt(41);
                }
                answers.add(incorrectanswer);
            }
        }
        button1.setText(Integer.toString(answers.get(0)));
        button2.setText(Integer.toString(answers.get(1)));
        button3.setText(Integer.toString(answers.get(2)));
        button4.setText(Integer.toString(answers.get(3)));
    }
    public void chooseanswer(View view){

        if(view.getTag().equals(Integer.toString(locationofcorrectanswer))){

            correct.setText("Correct!");
            scores++;

        }else{

            correct.setText("Wrong!");

        }
        numberofquestions++;
        pointstextview.setText(Integer.toString(scores)+"/"+Integer.toString(numberofquestions));
        newquestion();
    }
    public void start(View view){

        go.setVisibility(View.INVISIBLE);
        gameRelativeLayout.setVisibility(RelativeLayout.VISIBLE);

        playagain(findViewById(R.id.buttonplay));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        go=(Button)findViewById(R.id.startbutton);
        correct=(TextView)findViewById(R.id.textView);
         pointstextview=findViewById(R.id.pointstextView);
        button1=(Button)findViewById(R.id.button1);
        button2=(Button)findViewById(R.id.button2);
        button3=(Button)findViewById(R.id.button3);
        button4=(Button)findViewById(R.id.button4);
         sumTextview=(TextView)findViewById(R.id.sumTextView);
         timertextview=(TextView)findViewById(R.id.timertextView);
         playagain=(Button)findViewById(R.id.buttonplay);
        gameRelativeLayout =(RelativeLayout)findViewById(R.id.gameRelativeLayout);



    }
}
