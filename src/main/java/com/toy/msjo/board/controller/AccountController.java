package com.toy.msjo.board.controller;


import com.toy.msjo.board.domain.Account;
import com.toy.msjo.board.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    //BCtyptcom.toy.msjo
    @Autowired
    private PasswordEncoder passwordEncoder;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    private final String INVALID_ERROR = "Incorrect account information or NOT EXIST!";
    private final String SUCCESS_LOGIN = "Login is success!";

    @PostMapping("/login")
    public ResponseEntity login(HttpSession session, @RequestBody Account account) {

        logger.info("enter /login, method = POST");

        if(account != null) {

            //ID로 조회 된다면 해당 data, 아니면 NoArgConst
            Account newLoginAccount = accountService.login(account);

            logger.info("Newly want to login info " + newLoginAccount.toString());

            //Login
            if(newLoginAccount.getId() != null && passwordEncoder.matches(account.getPassword(), newLoginAccount.getPassword())) {

                logger.info("Valid account!! Before session's 'loginUser' = " + (Account)session.getAttribute("loginUser"));

                //기존에 로그인 정보 삭제
                if(session.getAttribute("loginUser") != null)
                    session.removeAttribute("loginUser");


                session.setAttribute("loginUser", account);

                logger.info("after refresh, login info = " + (Account)session.getAttribute("loginUser"));
                return ResponseEntity.ok().body(SUCCESS_LOGIN);
            }
        }

        logger.debug("Failure login");

            return ResponseEntity.badRequest().body(INVALID_ERROR);

    }

}
