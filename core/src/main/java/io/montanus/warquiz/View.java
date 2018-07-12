package io.montanus.warquiz;

public interface View {
    void setQuestion(Question question);
    void redirectToNoQuestionsFound();
}
