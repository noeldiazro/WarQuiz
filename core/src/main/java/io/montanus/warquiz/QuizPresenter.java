package io.montanus.warquiz;

public final class QuizPresenter {
    private final Repository repository;
    private final View view;

    public QuizPresenter(Repository repository, View view) {
        this.repository = repository;
        this.view = view;
    }

    public void onRender() {
        final Question question = repository.getQuestion();
        if (question == null)
            view.redirectToNoQuestionsFound();
        else
            view.setQuestion(question);
    }
}
