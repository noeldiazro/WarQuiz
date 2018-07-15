package io.montanus.warquiz.test;

import java.util.Collections;

import io.montanus.warquiz.InMemoryRepository;
import io.montanus.warquiz.QuestionImpl;
import io.montanus.warquiz.Repository;

public class RetrieveQuestionFromInMemoryRepositoryTest extends RetrieveQuestionFromRepositoryContract {

    @Override
    protected Repository getEmptyRepository() {
        return new InMemoryRepository(Collections.<QuestionImpl>emptyList());
    }

    @Override
    protected Repository getRepositoryIncluding(QuestionImpl question) {
        return new InMemoryRepository(Collections.singletonList(question));
    }

}
