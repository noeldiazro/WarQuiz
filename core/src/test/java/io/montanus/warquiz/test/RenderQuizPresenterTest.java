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

    @Test
    public void questionNotFound() {
        final Repository repository = context.mock(Repository.class);
        final View view = context.mock(View.class);

        context.checking(new Expectations() {{
            allowing(repository).getQuestion();
            will(returnValue(null));

            oneOf(view).redirectToNoQuestionsFound();
        }});

        final QuizPresenter quizPresenter = new QuizPresenter(repository, view);
        quizPresenter.onRender();
    }

    private interface View {
        void setQuestion(Question question);

        void redirectToNoQuestionsFound();
    }

    private static class QuizPresenter {
        private final Repository repository;
        private final View view;

        private QuizPresenter(Repository repository, View view) {
            this.repository = repository;
            this.view = view;
        }

        private void onRender() {
            final Question question = repository.getQuestion();
            if (question == null)
                view.redirectToNoQuestionsFound();
            else
                view.setQuestion(question);
        }
    }
}
