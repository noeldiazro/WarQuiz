package io.montanus.warquiz;

import java.util.List;

public final class InMemoryRepository implements Repository {
    private final List<Question> questions;

    public InMemoryRepository(List<Question> questions) {
        this.questions = questions;
    }

    public Question getQuestion() {
        if (questions.isEmpty())
            return null;
        else
            return questions.iterator().next();
    }
}
