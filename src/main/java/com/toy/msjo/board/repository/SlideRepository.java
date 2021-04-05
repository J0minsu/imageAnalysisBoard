package com.toy.msjo.board.repository;

import com.toy.msjo.board.domain.Slide;
import com.toy.msjo.board.domain.mapping.ForSearchSlideMapping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface SlideRepository extends JpaRepository<Slide, Integer> {

    //file id and fileName 만 가져오기
    Optional<ForSearchSlideMapping> findIdAndFileNameById(int id);

    //file id and fileName 만 가져오기
    Optional<ForSearchSlideMapping> findIdAndFileNameByFileName(String fileName);

    //자신 소유의 files id and fileName 만 가져오기
    ArrayList<ForSearchSlideMapping> findIdAndFileNameByAccountId(String accountId);

    //자신 소유의 Slide 중, file name 겸색해서 id fileName 가져오기
    ArrayList<ForSearchSlideMapping> findIdAndFileNameByAccountIdAndFileNameContaining(String accountId, String search);

    //account, id 일치하는 file download
    Slide findSlideByAccountIdAndId(String accountId, int id);
}
