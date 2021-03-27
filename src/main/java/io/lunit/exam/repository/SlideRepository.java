package io.lunit.exam.repository;

import io.lunit.exam.domain.Slide;
import io.lunit.exam.domain.mapping.ForSearchSlideMapping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface SlideRepository extends JpaRepository<Slide, Integer> {

    //file id and fileName 만 가져오기
    Optional<ForSearchSlideMapping> findIdAndFileNameById(int id);

    //file id and fileName 만 가져오기
    Optional<ForSearchSlideMapping> findIdAndFileNameByFileName(String fileName);

    //files id and fileName 만 가져오기
    ArrayList<ForSearchSlideMapping> findIdAndFileNameByAccountId(String accountId);

    //file name 겸색해서 자신소유의 files id and fileName
    ArrayList<ForSearchSlideMapping> findIdAndFileNameByAccountIdAndFileNameContaining(String accountId, String search);

    //account, id 일치하는 file download
    Slide findSlideByAccountIdAndId(String accountId, int id);
}
