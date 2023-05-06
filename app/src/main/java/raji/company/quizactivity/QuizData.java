package raji.company.quizactivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuizData {

    // Define mock quiz questions
    public static final List<Question> questions = new ArrayList<>(Arrays.asList(
            new Question("What is 8 + 4?", "12", "3", "5", "12", "math"),
            new Question("What is 3 x 5?", "15", "15", "12", "10", "math"),
            new Question("What is 5 factorial ?", "120", "4", "120", "10", "math"),
            new Question("What is the capital of Spain?", "Madrid", "Paris", "Madrid", "Berlin", "geography"),
            new Question("What is the largest organ in the human body?", "None of the above", "Liver", "Lungs", "None of the above", "anatomy")
    ));
}
