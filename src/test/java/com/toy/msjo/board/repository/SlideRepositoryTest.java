package com.toy.msjo.board.repository;

import com.toy.msjo.board.domain.mapping.ForSearchSlideMapping;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class SlideRepositoryTest {

    @Autowired
    SlideRepository repository;

    @Test
    void findByFileName() {

        Optional<ForSearchSlideMapping> mapping = repository.findIdAndFileNameByFileName("IMG_2552.JPG");

        System.out.println(mapping.get().getFileName() + mapping.get().getId());


    }

    @Test
    void findIdAndFileNameByAccountIdAndFileNameContaining() {

        ArrayList<ForSearchSlideMapping> mapping = repository.findIdAndFileNameByAccountIdAndFileNameContaining("msjo", "JPG");

        for (ForSearchSlideMapping mg : mapping)
            System.out.println(mg.getFileName() + "    " + mg.getId());
    }

}