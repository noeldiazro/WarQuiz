package io.montanus.warquiz.test;

import java.util.Collections;

import io.montanus.warquiz.InMemoryRepository;
import io.montanus.warquiz.Question;
import io.montanus.warquiz.Repository;

public class RetrieveQuestionFromInMemoryRepositoryTest extends RetrieveQuestionFromRepositoryContract {

    @Override
    protected Repository getEmptyRepository() {
        return new InMemoryRepository(Collections.<Question>emptyList());
    }

    @Override
    protected Repository getRepositoryIncluding(Question question) {
        return new InMemoryRepository(Collections.singletonList(question));
    }

}
