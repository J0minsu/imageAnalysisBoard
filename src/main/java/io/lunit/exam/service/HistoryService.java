package io.lunit.exam.service;

import io.lunit.exam.domain.History;
import io.lunit.exam.domain.mapping.ForSearchHistoryMapping;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface HistoryService {

    History analysisSlide(String id, int slideId) throws IOException;

    List<ForSearchHistoryMapping> searchHistories(String id);

    History searchHistory(String accountId, int historyId);
}
