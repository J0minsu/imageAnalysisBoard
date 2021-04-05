package com.toy.msjo.board.repository;

import com.toy.msjo.board.domain.History;
import com.toy.msjo.board.domain.mapping.ForSearchHistoryMapping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoryRepository extends JpaRepository<History, Integer> {

    List<ForSearchHistoryMapping> findByAccountId(String accountId);

    History findByAccountIdAndId(String accountId, int historyId);
}
