package io.lunit.exam.domain;

import io.lunit.exam.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(value = SpringExtension.class)
@SpringBootTest
class AccountTest {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AccountRepository repository;

    @Test
    public void test() {


        if(passwordEncoder.matches("950227", repository.findById("msjo").orElse(new Account()).getPassword()))
            System.out.println("correct");
        else
            System.out.println("incorrect");

    }

}