package io.montanus.warquiz;

public interface View {
    void setQuestion(QuestionImpl question);
    void redirectToNoQuestionsFound();
}
