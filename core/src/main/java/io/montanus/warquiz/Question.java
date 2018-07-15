package io.montanus.warquiz;

public final class Question {
    private final String text;

    public Question(String text, Answer correctAnswer) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public Result check(Answer userAnswer) {
        return Result.RIGHT;
    }
}
