package io.montanus.warquiz;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;

public class QuizActivity extends Activity implements View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        final Question question = new Question(getString(R.string.germany_question));
        final InMemoryRepository repository =
                new InMemoryRepository(Collections.singletonList(question));
        final QuizPresenter quizPresenter = new QuizPresenter(repository, this);

        quizPresenter.onRender();
    }

    @Override
    public void setQuestion(Question question) {
        final TextView questionText = findViewById(R.id.question_text);
        questionText.setText(question.getText());
    }

    @Override
    public void redirectToNoQuestionsFound() {
        Toast.makeText(this, R.string.no_questions_msg, Toast.LENGTH_LONG).show();
    }
}
