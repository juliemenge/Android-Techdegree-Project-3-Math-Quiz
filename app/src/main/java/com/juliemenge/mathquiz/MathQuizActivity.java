package com.juliemenge.mathquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MathQuizActivity extends AppCompatActivity {
    // comment
    //Numbers to be added
    private TextView mLeftAdderTextView;
    private TextView mRightAdderTextView;

    //Answer option buttons and radio group
    private RadioGroup mRadioOptionsGroup;
    private RadioButton mLeftAnswerOptionButton;
    private RadioButton mMiddleAnswerOptionButton;
    private RadioButton mRightAnswerOptionButton;

    //Submit button
    private Button mSubmitButton;

    //radio button to store the answer the user chooses
    private RadioButton mAnswerSelectionButton;

    //object to create bank of questions
    private QuestionBank mQuestionBank = new QuestionBank();

    //store the index of where we are in the arrays
    //int questionIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_quiz);

        //assign member variables to corresponding variables within code
        mLeftAdderTextView = (TextView) findViewById(R.id.leftAdderTextView);
        mRightAdderTextView = (TextView) findViewById(R.id.rightAdderTextView);

        int questionIndex = 0;

        //when app starts, set text of left and right adders to first question in question bank
        mLeftAdderTextView.setText(mQuestionBank.leftAdders[questionIndex]+"");
        mRightAdderTextView.setText(mQuestionBank.rightAdders[questionIndex]+"");

        addListenerOnButton(); //check to see which radio button was selected and toast correct or incorrect
    }

    private void addListenerOnButton() {
        //assign buttons to corresponding variables
        mRadioOptionsGroup = (RadioGroup) findViewById(R.id.radioButtonsGroup);
        mLeftAnswerOptionButton = (RadioButton) findViewById(R.id.leftAnswerOptionButton);
        mMiddleAnswerOptionButton = (RadioButton) findViewById(R.id.middleAnswerOptionButton);
        mRightAnswerOptionButton = (RadioButton) findViewById(R.id.rightAnswerOptionButton);

        mSubmitButton = (Button) findViewById(R.id.submitButton);

        mLeftAnswerOptionButton.setText(mQuestionBank.correctAnswers[0]+"");
        mMiddleAnswerOptionButton.setText(mQuestionBank.firstIncorrectAnswers[0]+"");
        mRightAnswerOptionButton.setText(mQuestionBank.secondIncorrectAnswers[0]+"");

        //when the Submit button is clicked, toasts if the answer is correct
        //TO DO: if statement to see if it matches correct answer in array, after answer displays, show next question
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                //get selected radio button that the user chose from radio group
                int selectedId = mRadioOptionsGroup.getCheckedRadioButtonId();

                //find the radio button by its ID
                mAnswerSelectionButton = (RadioButton) findViewById(selectedId);
                String answerText = (String) mAnswerSelectionButton.getText();

                //display a toast message if the user is correct - displaying button text for now, change to correct or incorrect
                if((mQuestionBank.leftAdders[0] + mQuestionBank.rightAdders[0]) == Integer.parseInt(answerText)) {
                    Toast.makeText(MathQuizActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
                } else
                   Toast.makeText(MathQuizActivity.this, "Incorrect!", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
