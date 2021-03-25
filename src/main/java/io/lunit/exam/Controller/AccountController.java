package io.lunit.exam.Controller;


import io.lunit.exam.Domain.Account;
import io.lunit.exam.Service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    private final String INVALID_ERROR = "Incorrect account information or NOT EXIST!";
    private final String SUCCESS_LOGIN = "Login is success!";

    @PostMapping("/login")
    public ResponseEntity login(HttpSession session, @RequestBody Account account) {

        logger.info("enter /login, method = POST");

        if(account != null) {

            //ID로 조회 된다면 해당 data, 아니면 NoArgConst
            Account newLoginAccount = accountService.login(account);

            logger.info(newLoginAccount.toString());

            //Login 성공
            if(newLoginAccount.getId() != null && newLoginAccount.getPassword().equals(account.getPassword())) {

                logger.info("Valid new Account!! Before session's 'loginUser' = " + (Account)session.getAttribute("loginUser"));

                //기존에 로그인 정보 있는 경우, 기존 Attribute 삭제
                if(session.getAttribute("loginUser") != null)
                    session.removeAttribute("loginUser");


                session.setAttribute("loginUser", account);

                logger.info("after refresh, login info = " + (Account)session.getAttribute("loginUser"));


                return new ResponseEntity(SUCCESS_LOGIN, HttpStatus.OK);
            }
        }

            return new ResponseEntity(INVALID_ERROR, HttpStatus.NOT_ACCEPTABLE);

    }
}
