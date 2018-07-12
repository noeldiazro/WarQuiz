package io.montanus.warquiz.test;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

public final class RenderQuizPresenterTest {
    @Rule
    public final JUnitRuleMockery context = new JUnitRuleMockery();

    @Test
    public void questionFound() {
        final Repository repository = context.mock(Repository.class);
        final Question question = new Question();
        final View view = context.mock(View.class);

        context.checking(new Expectations() {{
            allowing(repository).getQuestion();
            will(returnValue(question));

            oneOf(view).setQuestion(with(question));
        }});

        final QuizPresenter quizPresenter = new QuizPresenter(repository, view);
        quizPresenter.onRender();
    }

    private interface Repository {
        Question getQuestion();
    }

    private interface View {
        void setQuestion(Question question);
    }

    private static class Question {
    }

    private static class QuizPresenter {
        private final Repository repository;
        private final View view;

        private QuizPresenter(Repository repository, View view) {
            this.repository = repository;
            this.view = view;
        }

        private void onRender() {
            view.setQuestion(repository.getQuestion());
        }
    }
}
