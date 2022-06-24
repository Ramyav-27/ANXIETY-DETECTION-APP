package com.example.vbot;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView totalquestionTextView;
    TextView questionTextView;
    Button ans0,ans1,ans2,ans3,ans4,ans5;
    Button submitbtn;
    int score=0;
    int totalQuestion=QuestionAnswer.question.length;
    int currentQuestionIndex=0;
    String selectedAnswer="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totalquestionTextView = findViewById(R.id.total_question);
        questionTextView = findViewById(R.id.question);
        ans0 = findViewById(R.id.ans_0);
        ans1 = findViewById(R.id.ans_1);
        ans2 = findViewById(R.id.ans_2);
        ans3 = findViewById(R.id.ans_3);
        ans4 = findViewById(R.id.ans_4);
        ans5 = findViewById(R.id.ans_5);
        submitbtn = findViewById(R.id.submit_btn);

        ans0.setOnClickListener(this);
        ans1.setOnClickListener(this);
        ans2.setOnClickListener(this);
        ans3.setOnClickListener(this);
        ans4.setOnClickListener(this);
        ans5.setOnClickListener(this);
        submitbtn.setOnClickListener(this);

        totalquestionTextView.setText("" +
                "Rate your answers from 0 to 5, " +
                "where 0=VERY LOW,1=LOW,2=SOMETIMES,3=MEDIUM,4=HIGH,5=VERY HIGH" +
                " Total number of Questions:" + totalQuestion);

        loadNewQuestion();

    }

    @Override
    public void onClick(View view) {
Button clickedButton=(Button) view;

if(clickedButton.getId()==R.id.submit_btn)
{
    if(selectedAnswer.equals(QuestionAnswer.correctAnswers[currentQuestionIndex]))
    {
        score++;
    }
    currentQuestionIndex++;
    loadNewQuestion();

}
else {
    selectedAnswer=clickedButton.getText().toString();


    clickedButton.setBackgroundColor(Color.CYAN);

}
    }
    void loadNewQuestion()
    {
        if(currentQuestionIndex==totalQuestion)
        {
            finishQuiz();
            return;
        }
        questionTextView.setText(QuestionAnswer.question[currentQuestionIndex]);
        ans0.setText(QuestionAnswer.choices[currentQuestionIndex][0]);
        ans1.setText(QuestionAnswer.choices[currentQuestionIndex][1]);
        ans2.setText(QuestionAnswer.choices[currentQuestionIndex][2]);
        ans3.setText(QuestionAnswer.choices[currentQuestionIndex][3]);
        ans4.setText(QuestionAnswer.choices[currentQuestionIndex][4]);
        ans5.setText(QuestionAnswer.choices[currentQuestionIndex][5]);
    }
void finishQuiz(){
        String passStatus="";
        if(score<totalQuestion*0.10)
        {
            passStatus="Minimal Anxiety" +
                    " Drink sufficient water at regular intervals";
        }
        else if(score<totalQuestion*0.30)
        {
            passStatus="Mild Anxiety" +
                    " Relaxing music helps you";
        }
        else if(score<totalQuestion*0.50)
    {
        passStatus="Moderate Anxiety" +
                " Make your time for YOU";
    }
        else
    {
        passStatus="Severe Anxiety" +
                " It's better to consult a specialist";
    }
        new  AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setPositiveButton("Restart",(dialogInterface, i) -> restartQuiz())
                .setCancelable(false)
                .show();
}
void restartQuiz()
{
    score=0;
    currentQuestionIndex=0;
    loadNewQuestion();

}


}
