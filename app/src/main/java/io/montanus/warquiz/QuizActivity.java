package io.montanus.warquiz;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Collections;

public class QuizActivity extends Activity implements View {
    private final QuizPresenter quizPresenter;

    public QuizActivity() {
        final InMemoryRepository repository =
                new InMemoryRepository(Collections.singletonList(new Question("::irrelevant::")));
        quizPresenter = new QuizPresenter(repository, this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        quizPresenter.onRender();
    }

    @Override
    public void setQuestion(Question question) {
        final TextView questionText = findViewById(R.id.question_text);
        questionText.setText(question.toString());
    }

    @Override
    public void redirectToNoQuestionsFound() {
        // TODO
    }
}
