package com.juliemenge.mathquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MathQuizActivity extends AppCompatActivity {

    //Numbers to be added
    private TextView mLeftAdderTextView;
    private TextView mRightAdderTextView;

    //Answer options
    private TextView mLeftAnswerOption;
    private TextView mMiddleAnswerOption;
    private TextView mRightAnswerOption;

    //Answer option buttons and radio group
    private RadioGroup mRadioOptionsGroup;
    private RadioButton mLeftAnswerOptionButton;
    private RadioButton mMiddleAnswerOptionButton;
    private RadioButton mRightAnswerOptionButton;

    //Submit button
    private Button mSubmitButton;

    //object to create bank of questions
    private QuestionBank mQuestionBank = new QuestionBank();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_quiz);

        //assign member variables to corresponding variables within code
        mLeftAdderTextView = (TextView) findViewById(R.id.leftAdderTextView);
        mRightAdderTextView = (TextView) findViewById(R.id.rightAdderTextView);

        mLeftAnswerOption = (TextView) findViewById(R.id.leftAnswerOptionTextView);
        mMiddleAnswerOption = (TextView) findViewById(R.id.middleAnswerOptionTextView);
        mRightAnswerOption = (TextView) findViewById(R.id.rightAnswerOptionTextView);

        mLeftAnswerOptionButton = (RadioButton) findViewById(R.id.leftAnswerOptionButton);
        mMiddleAnswerOptionButton = (RadioButton) findViewById(R.id.middleAnswerOptionButton);
        mRightAnswerOptionButton = (RadioButton) findViewById(R.id.rightAnswerOptionButton);

        mSubmitButton = (Button) findViewById(R.id.submitButton);

        //make the Submit button do something when it is clicked - right now, just returning which button was clicked
        View.OnClickListener listener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //when the button is clicked, return which radio button was selected

            }
        };

        //The button was clicked, so let the user know if the answer is correct
        mSubmitButton.setOnClickListener(listener);
    }
}
