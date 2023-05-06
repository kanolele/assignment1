package raji.company.quizactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView textViewQuestion;
    private Button buttonOption1;
    private Button buttonOption2;
    private Button buttonOption3;
    private Button buttonNext;
    private Button buttonFinish;
    private List<Question> questions;
    private static int questionIndex = 0;
    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // Initialize views
        textViewQuestion = findViewById(R.id.textViewQuestion);
        buttonOption1 = findViewById(R.id.buttonOption1);
        buttonOption2 = findViewById(R.id.buttonOption2);
        buttonOption3 = findViewById(R.id.buttonOption3);
        buttonNext = findViewById(R.id.buttonNext);
        // Load quiz questions
        questions = QuizData.questions;

        loadQuestion(questionIndex);
        // Set button click listeners
        buttonOption1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            buttonOption1.setBackgroundColor(Color.BLUE);
            buttonOption2.setBackgroundColor(Color.TRANSPARENT);
            buttonOption3.setBackgroundColor(Color.TRANSPARENT);
                checkAnswer(buttonOption1);
            }
        });

        buttonOption2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonOption1.setBackgroundColor(Color.TRANSPARENT);
                buttonOption2.setBackgroundColor(Color.BLUE);
                buttonOption3.setBackgroundColor(Color.TRANSPARENT);
                checkAnswer(buttonOption2);
            }
        });

        buttonOption3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonOption1.setBackgroundColor(Color.TRANSPARENT);
                buttonOption2.setBackgroundColor(Color.TRANSPARENT);
                buttonOption3.setBackgroundColor(Color.BLUE);
                checkAnswer(buttonOption3);
            }
        });

            buttonNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    buttonOption1.setBackgroundColor(Color.TRANSPARENT);
                    buttonOption2.setBackgroundColor(Color.TRANSPARENT);
                    buttonOption3.setBackgroundColor(Color.TRANSPARENT);
                    loadNextQuestion();
                }
            });


    }

    private void loadQuestion(int index) {
        Question question = questions.get(index);
        textViewQuestion.setText(question.getQuestion());
        buttonOption1.setText(question.getOption1());
        buttonOption2.setText(question.getOption2());
        buttonOption3.setText(question.getOption3());
    }

    private void checkAnswer(Button selectedButton) {

        Question question = questions.get(questionIndex);

        if ( selectedButton.getText().equals(question.getAnswer()))
        {

            Toast.makeText(this,"Correct", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this,"InCorrect", Toast.LENGTH_SHORT).show();
        }



    }


    private void loadNextQuestion() {

        if (questionIndex < questions.size() - 1) {

            questionIndex++;
            loadQuestion(questionIndex);
        } else {

            questionIndex = 0;
            loadQuestion(questionIndex);
        }
    }
}
