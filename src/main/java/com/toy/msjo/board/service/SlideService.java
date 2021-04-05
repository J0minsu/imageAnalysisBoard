package com.toy.msjo.board.service;

import com.toy.msjo.board.domain.Account;
import com.toy.msjo.board.domain.Slide;
import com.toy.msjo.board.domain.mapping.ForSearchSlideMapping;

import java.util.ArrayList;

public interface SlideService {

    //slide save method
    String save(Slide slide);

    //id로 slide id and slide name 가져오기
    ForSearchSlideMapping findSlideIdAndFileNameById(int i);

    //fileName과 accountId 로 slide id and slide name 가져오기
    ArrayList<ForSearchSlideMapping> searchSlides(String accountId, String search);

    //accountId 로 자신의 slide id and slide name 가져오기
    ArrayList<ForSearchSlideMapping> findSlidesIdAndFileNameByAccount(Account Account);

    //accountId 와 id 일치하는 slide 다운로드
    Slide download(String accountId, int slideId);
}
