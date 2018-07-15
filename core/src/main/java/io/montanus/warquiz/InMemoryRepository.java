package io.montanus.warquiz;

import java.util.List;

public final class InMemoryRepository implements Repository {
    private final List<QuestionImpl> questions;

    public InMemoryRepository(List<QuestionImpl> questions) {
        this.questions = questions;
    }

    public QuestionImpl getQuestion() {
        if (questions.isEmpty())
            return null;
        else
            return questions.iterator().next();
    }
}
