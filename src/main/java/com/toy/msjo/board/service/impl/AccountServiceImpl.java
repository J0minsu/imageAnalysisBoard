package io.lunit.exam.service.impl;

import io.lunit.exam.domain.Account;
import io.lunit.exam.repository.AccountRepository;
import io.lunit.exam.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {


    @Autowired
    private AccountRepository repository;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Account login(Account account) {

        //신규 접근하는 계정의 PW 와 DB에 저장된 PW 비교 ( NOT NULL 옵션이기 때문에, PW 공백이슈 X )
        //ID 일치하는 계정이 있다면 정상적인 동작, 일치하는 계정정보 없다면 Empty bean
        Account newLoginAccount = repository.findById(account.getId()).orElse(new Account());


        return newLoginAccount;
    }


}
