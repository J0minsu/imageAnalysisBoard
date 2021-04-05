package com.toy.msjo.board.service.impl;

import com.toy.msjo.board.repository.AccountRepository;
import com.toy.msjo.board.repository.SlideRepository;
import com.toy.msjo.board.service.HistoryService;
import com.toy.msjo.board.domain.Account;
import com.toy.msjo.board.domain.History;
import com.toy.msjo.board.domain.Slide;
import com.toy.msjo.board.domain.mapping.ForSearchHistoryMapping;
import com.toy.msjo.board.dto.Analysis;
import com.toy.msjo.board.dto.Grid;
import com.toy.msjo.board.repository.HistoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;


@Service
public class HistoryServiceImpl implements HistoryService {

    @Autowired
    SlideRepository slideRepository;

    @Autowired
    HistoryRepository historyRepository;

    @Autowired
    AccountRepository accountRepository;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final String ANALYSIS_SERVER_URL = "";

    @Override
    public History analysisSlide(String accountId, int slideId) throws IOException {

        Slide slide = slideRepository.findSlideByAccountIdAndId(accountId, slideId);
        Account account = accountRepository.findById(accountId).orElse(new Account());
        History history = new History();

        //일치하는 Slide가 없을 떄
        if(slide == null) return new History();

        /*                              */
        /*   실제 분석서버에 요청하는 Logic   */
        /*                              */
        /*
        //Slide convert to byte array
        InputStream imageStram = new FileInputStream(slide.getFilePath());
        byte [] imageByteArray = imageStram.readAllBytes();
        imageStram.close();

        //about Slide info setting in header
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);

        //body에 저장
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("image", imageByteArray);

        //분석 서버 <->
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);
        ResponseEntity<String> response = new RestTemplate().postForEntity(ANALYSIS_SERVER_URL, requestEntity, String.class);

        //String(Json) -> Dto 파싱
        ObjectMapper mapper = new ObjectMapper();
        Analysis analysis = mapper.readValue(response.getBody(), Analysis.class);

        //분석 실패
        if(analysis.getErrorMessage() != null) {
            history.setIsSuccess(false);
            history.setResult(analysis.getErrorMessage());
        }
        //분석 성공
        else {
            history.setIsSuccess(true);
            history.setResult(analysis.toString());
        }

        history.setSlide(slideRepository.findById(slideId).orElse(new Slide()));
        history.setAccount(accountRepository.findById(accountId).orElse(new Account()));
        historyRepository.save(history);

        return history;

         */


        /*          dummy data 생성           */
        /*                                   */

        //분석 성공
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


        history.setSlide(slide);
        history.setAccount(account);

        historyRepository.save(history);

        slide.securitySet();
        account.securitySet();

        return history;
    }

    @Override
    public List<ForSearchHistoryMapping> searchHistories(String accountId) {

        List<ForSearchHistoryMapping> histories = historyRepository.findByAccountId(accountId);

        for(ForSearchHistoryMapping mapping : histories) {
            mapping.getSlide().securitySet();
        }

        return histories;
    }

    @Override
    public History searchHistory(String accountId, int historyId) {

        History history = historyRepository.findByAccountIdAndId(accountId, historyId);

        history.getSlide().securitySet();;
        history.getAccount().securitySet();

        return history;
    }
}
