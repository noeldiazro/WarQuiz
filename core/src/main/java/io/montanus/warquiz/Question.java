package io.montanus.warquiz;

public final class Question {
    private final String text;
    private final Answer correctAnswer;

    public Question(String text, Answer correctAnswer) {
        this.text = text;
        this.correctAnswer = correctAnswer;
    }

    public String getText() {
        return text;
    }

    public Result check(Answer userAnswer) {
        return correctAnswer == userAnswer ? Result.RIGHT : Result.WRONG;
    }
}
