package io.montanus.warquiz.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.ArrayList;
import java.util.Collection;

import io.montanus.warquiz.Answer;
import io.montanus.warquiz.Question;
import io.montanus.warquiz.Result;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public final class CheckAnswerToQuestionTest {

    private final Answer correctAnswer;
    private final Result expectedResult;
    private final Answer userAnswer;

    public CheckAnswerToQuestionTest(
            Answer correctAnswer, Answer userAnswer, Result expectedResult) {
        this.correctAnswer = correctAnswer;
        this.userAnswer = userAnswer;
        this.expectedResult = expectedResult;
    }

    @Parameters(name = "Correct answer is {0} and user responds {1}, then result is {2}")
    public static Collection<Object[]> parameters() {
        return new ArrayList<Object[]>() {{
            add(new Object[] {Answer.TRUE, Answer.TRUE, Result.RIGHT});
            add(new Object[] {Answer.TRUE, Answer.FALSE, Result.WRONG});
        }};
    }

    @Test
    public void bothCorrectAndUserAnswerAreTrue() {
        final Question question = new Question("::irrelevant::", correctAnswer);
        assertEquals(expectedResult, question.check(userAnswer));
    }
}
