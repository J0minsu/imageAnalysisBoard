package com.toy.msjo.board.controller;


import com.toy.msjo.board.service.HistoryService;
import com.toy.msjo.board.domain.Account;
import com.toy.msjo.board.domain.History;
import com.toy.msjo.board.domain.mapping.ForSearchHistoryMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/histories")
public class HistoryController {

    @Autowired
    HistoryService historyService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping()
    public ResponseEntity<List<ForSearchHistoryMapping>> searchHistories(HttpSession session) {

        logger.info("enter /histories, method = GET : find all history you have permission");

        Account account = (Account)session.getAttribute("loginUser");

        List<ForSearchHistoryMapping> histories = historyService.searchHistories(account.getId());

        return ResponseEntity.ok().body(histories);
    }

    @GetMapping("{historyId}")
    public ResponseEntity<History> searchHistory(@PathVariable int historyId, HttpSession session) {

        logger.info("enter /searchHistories, method = GET : find history user request ");

        Account account = (Account)session.getAttribute("loginUser");

        History history = historyService.searchHistory(account.getId(), historyId);

        if(history == null)
            return ResponseEntity.noContent().build();

        else
            return ResponseEntity.ok(history);

    }

    @GetMapping("/analysis/{slideId}")
    public ResponseEntity<History> analysisSlide(@PathVariable int slideId, HttpSession session) throws IOException {

        logger.info("enter /analysis, method = GET : request analize slide you have permission ");

        Account account = (Account) session.getAttribute("loginUser");

        History history = historyService.analysisSlide(account.getId(), slideId);

        //Validation
        if(history == null || history.getResult() == null) {
            logger.info("analysis is fail");
            return ResponseEntity.noContent().build();
        }

        logger.info("analysis is success");

        return ResponseEntity.ok().body(history);
    }




}
