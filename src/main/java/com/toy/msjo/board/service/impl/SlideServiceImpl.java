package com.toy.msjo.board.service.impl;

import com.toy.msjo.board.service.SlideService;
import com.toy.msjo.board.domain.Account;
import com.toy.msjo.board.domain.Slide;
import com.toy.msjo.board.domain.mapping.ForSearchSlideMapping;
import com.toy.msjo.board.repository.SlideRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SlideServiceImpl implements SlideService {

    @Autowired
    SlideRepository repository;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    static final String DUPLICATE_ID = "Same id's file is already exist!";
    static final String DUPLICATE_FILE_NAME = "Same name's file is already exist!";
    static final String SUCCESS_UPLOAD = "Success slide upload!";

    @Override
    public String save(Slide slide) {

       //When id is duplicated
        if(!repository.findIdAndFileNameById(slide.getId()).isEmpty())
            return DUPLICATE_ID;

        //When file name is duplicated
        if(!repository.findIdAndFileNameByFileName(slide.getFileName()).isEmpty())
            return DUPLICATE_FILE_NAME;

        repository.save(slide);

        return SUCCESS_UPLOAD;

    }

    @Override
    public ForSearchSlideMapping findSlideIdAndFileNameById(int i) {
        return null;
    }

    @Override
    public ArrayList<ForSearchSlideMapping> searchSlides(String accountId, String search) {

        ArrayList<ForSearchSlideMapping> slidesInfo = repository.findIdAndFileNameByAccountIdAndFileNameContaining(accountId, search);

        return slidesInfo;
    }

    @Override
    public ArrayList<ForSearchSlideMapping> findSlidesIdAndFileNameByAccount(Account account) {

        ArrayList<ForSearchSlideMapping> list = repository.findIdAndFileNameByAccountId(account.getId());

        return list;
    }

    @Override
    public Slide download(String accountId, int slideId) {

        Slide slide = repository.findSlideByAccountIdAndId(accountId, slideId);

        return slide;
    }
}
