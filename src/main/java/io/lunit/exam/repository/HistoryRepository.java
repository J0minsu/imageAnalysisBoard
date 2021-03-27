package io.lunit.exam.repository;

import io.lunit.exam.domain.History;
import io.lunit.exam.domain.mapping.ForSearchHistoryMapping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoryRepository extends JpaRepository<History, Integer> {

    List<ForSearchHistoryMapping> findByAccountId(String accountId);

    History findByAccountIdAndId(String accountId, int historyId);
}
