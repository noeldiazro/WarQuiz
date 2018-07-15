package io.montanus.warquiz.test;

import org.junit.Test;

import io.montanus.warquiz.Answer;
import io.montanus.warquiz.Question;
import io.montanus.warquiz.Result;

import static org.junit.Assert.assertEquals;

public final class CheckAnswerToQuestionTest {
    @Test
    public void bothCorrectAndUserAnswerAreTrue() {
        final Question question = new Question("::irrelevant::", Answer.TRUE);
        assertEquals(Result.RIGHT, question.check(Answer.TRUE));
    }
}
