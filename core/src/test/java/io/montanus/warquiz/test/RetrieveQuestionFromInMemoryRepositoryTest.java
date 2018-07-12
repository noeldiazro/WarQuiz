package io.montanus.warquiz.test;

import java.util.Collections;
import java.util.List;

public class RetrieveQuestionFromInMemoryRepositoryTest extends RetrieveQuestionFromRepositoryContract {

    @Override
    protected Repository getEmptyRepository() {
        return new InMemoryRepository(Collections.<Question>emptyList());
    }

    @Override
    protected Repository getRepositoryIncluding(Question question) {
        return new InMemoryRepository(Collections.singletonList(question));
    }

    private static class InMemoryRepository implements Repository {
        private final List<Question> questions;

        private InMemoryRepository(List<Question> questions) {
            this.questions = questions;
        }

        public Question getQuestion() {
            if (questions.isEmpty())
                return null;
            else
                return questions.iterator().next();
        }
    }
}
