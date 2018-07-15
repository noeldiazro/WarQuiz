package io.montanus.warquiz.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import io.montanus.warquiz.Answer;
import io.montanus.warquiz.QuestionImpl;
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
        return Arrays.asList(new Object[][]{
                {Answer.TRUE, Answer.TRUE, Result.RIGHT},
                {Answer.TRUE, Answer.FALSE, Result.WRONG},
                {Answer.FALSE, Answer.TRUE, Result.WRONG},
                {Answer.FALSE, Answer.FALSE, Result.RIGHT}
        });
    }

    @Test
    public void bothCorrectAndUserAnswerAreTrue() {
        final QuestionImpl question = new QuestionImpl("::irrelevant::", correctAnswer);
        assertEquals(expectedResult, question.check(userAnswer));
    }
}
