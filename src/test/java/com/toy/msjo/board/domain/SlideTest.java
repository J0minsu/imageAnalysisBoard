package io.lunit.exam.domain;

import io.lunit.exam.service.impl.AccountServiceImpl;
import io.lunit.exam.service.impl.SlideServiceImpl;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class SlideTest {

    @Autowired
    SlideServiceImpl service;


    public void test() {

    }

}