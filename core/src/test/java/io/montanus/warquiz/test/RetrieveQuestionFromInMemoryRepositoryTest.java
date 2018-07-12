package io.montanus.warquiz.test;

import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RetrieveQuestionFromInMemoryRepositoryTest {
    @Test
    public void zeroQuestions() {
        final InMemoryRepository repository =
                new InMemoryRepository(Collections.<Question>emptyList());
        assertEquals(null, repository.getQuestion());
    }

    @Test
    public void oneQuestion() {
        final Question question = new Question();
        final InMemoryRepository repository =
                new InMemoryRepository(Collections.singletonList(question));
        assertEquals(question, repository.getQuestion());
    }

    private static class InMemoryRepository {
        private final List<Question> questions;

        private InMemoryRepository(List<Question> questions) {
            this.questions = questions;
        }

        private Question getQuestion() {
            if (questions.isEmpty())
                return null;
            else
                return questions.iterator().next();
        }
    }
}
