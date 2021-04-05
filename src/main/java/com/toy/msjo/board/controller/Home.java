package com.toy.msjo.board.controller;

import com.toy.msjo.board.domain.Account;
import com.toy.msjo.board.domain.mapping.ForSearchSlideMapping;
import com.toy.msjo.board.repository.AccountRepository;
import com.toy.msjo.board.repository.SlideRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@RestController
@RequestMapping("/test")
public class Home {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    SlideRepository slideRepository;

    @GetMapping()
    public ModelAndView login(HttpSession session) {

        logger.info("Success Login & Go to home");

        Account account = accountRepository.findById("msjo").orElse(new Account());

        //for slide up/download test
        session.setAttribute("loginUser", account);

        ModelAndView view = new ModelAndView();
        view.setViewName("/home");

        return view;
    }

    @GetMapping("upload")
    public ModelAndView slideUpload() {

        logger.info("enter upload test page");

        ModelAndView view = new ModelAndView();
        view.setViewName("/upload");

        return view;
    }

    @GetMapping("allSlide")
    public ModelAndView downloadableSlides(HttpSession session) {

        logger.info("enter all slide test page");

        ModelAndView view = new ModelAndView();

        Account account = (Account)session.getAttribute("loginUser");

        ArrayList<ForSearchSlideMapping> mappings = slideRepository.findIdAndFileNameByAccountId(account.getId());
        view.addObject("slides", mappings);

        view.setViewName("/allSlide");

        return view;
    }

    @GetMapping("search")
    public ModelAndView slideSearch() {

        logger.info("enter search test page");

        ModelAndView view = new ModelAndView();
        view.setViewName("/search");

        return view;
    }

    @GetMapping("otherLogin")
    public ModelAndView changeLogin(HttpSession session) {

        logger.info("change user msjo -> jslee");

        Account account = accountRepository.findById("jslee").orElse(new Account());


        //기존 로그인 정보 폐기
        session.removeAttribute("loginUser");

        //New 로그인 정보 주입
        session.setAttribute("loginUser", account);

        ModelAndView view = new ModelAndView();
        view.setViewName("/home");

        return view;
    }
}
