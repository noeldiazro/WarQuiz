package io.montanus.warquiz.test;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public abstract class RetrieveQuestionFromRepositoryContract {
    @Test
    public void zeroQuestions() {
        final Repository repository = getEmptyRepository();
        assertEquals(null, repository.getQuestion());
    }

    protected abstract Repository getEmptyRepository();

    @Test
    public void oneQuestion() {
        final Question question = new Question();
        final Repository repository = getRepositoryIncluding(question);
        assertEquals(question, repository.getQuestion());
    }

    protected abstract Repository getRepositoryIncluding(Question question);
}
