package io.montanus.warquiz.test;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

import io.montanus.warquiz.Answer;
import io.montanus.warquiz.QuestionImpl;
import io.montanus.warquiz.QuizPresenter;
import io.montanus.warquiz.Repository;
import io.montanus.warquiz.View;

public final class RenderQuizPresenterTest {
    @Rule
    public final JUnitRuleMockery context = new JUnitRuleMockery();

    @Test
    public void questionFound() {
        final Repository repository = context.mock(Repository.class);
        final Answer irrelevantAnswer = Answer.TRUE;
        final QuestionImpl question = new QuestionImpl("::irrelevant::", irrelevantAnswer);
        final View view = context.mock(View.class);

        context.checking(new Expectations() {{
            allowing(repository).getQuestionImpl();
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
            allowing(repository).getQuestionImpl();
            will(returnValue(null));

            oneOf(view).redirectToNoQuestionsFound();
        }});

        final QuizPresenter quizPresenter = new QuizPresenter(repository, view);
        quizPresenter.onRender();
    }

}
