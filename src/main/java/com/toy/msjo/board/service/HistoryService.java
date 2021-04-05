package com.toy.msjo.board.service;

import com.toy.msjo.board.domain.History;
import com.toy.msjo.board.domain.mapping.ForSearchHistoryMapping;

import java.io.IOException;
import java.util.List;

public interface HistoryService {

    History analysisSlide(String id, int slideId) throws IOException;

    List<ForSearchHistoryMapping> searchHistories(String id);

    History searchHistory(String accountId, int historyId);
}
