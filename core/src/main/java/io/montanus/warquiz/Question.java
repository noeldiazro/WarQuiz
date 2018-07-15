package io.montanus.warquiz;

public interface Question {
    String getText();

    Result check(Answer userAnswer);
}
