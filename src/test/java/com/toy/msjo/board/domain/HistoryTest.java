package com.toy.msjo.board.domain;

import com.toy.msjo.board.dto.Analysis;
import com.toy.msjo.board.dto.Grid;
import com.toy.msjo.board.repository.AccountRepository;
import com.toy.msjo.board.repository.HistoryRepository;
import com.toy.msjo.board.repository.SlideRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class HistoryTest {

    @Autowired
    HistoryRepository historyRepository;

    @Autowired
    SlideRepository slideRepository;

    @Autowired
    AccountRepository accountRepository;

    @Test
    public void test() {

        History history = new History();
        int slideId = 5;
        String accountId = "msjo";

        if((int)(Math.random()*2+1) == 1) {
            history.setIsSuccess(true);

            Analysis analysis = new Analysis();

            if((int)(Math.random()*2+1) == 1) analysis.setDecision(true);
            else                              analysis.setDecision(false);

            analysis.setSCOPE((float)Math.random());
            analysis.setCutoff((float)Math.random());


            //Grid 갯수 랜덤 20~50
            for(int i = 0; i < (int)(Math.random()*50+20); i++) {
                Grid grid = new Grid((float)Math.random(),(float)Math.random(),(float)Math.random(),
                        (float)Math.random(),(float)Math.random(),(float)Math.random());

                analysis.addGird(grid);
            }

            history.setResult(analysis.toString());
        }
        //분석 실패
        else {
            history.setIsSuccess(false);
            history.setResult("Analysis is fail");
        }

        //공통 구현

        history.setSlide(slideRepository.findById(slideId).orElse(new Slide()));
        history.setAccount(accountRepository.findById(accountId).orElse(new Account()));

        historyRepository.save(history);
    }

}