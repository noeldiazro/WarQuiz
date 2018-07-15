package io.montanus.warquiz;

interface Question {
    String getText();

    Result check(Answer userAnswer);
}
