package com.toy.msjo.board.repository;

import com.toy.msjo.board.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {

}
