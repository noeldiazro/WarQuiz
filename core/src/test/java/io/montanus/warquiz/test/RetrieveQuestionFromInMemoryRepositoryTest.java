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

    private static class InMemoryRepository {
        private InMemoryRepository(List<Question> questions) {

        }

        private Question getQuestion() {
            return null;
        }
    }
}
