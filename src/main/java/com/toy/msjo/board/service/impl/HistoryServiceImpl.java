package io.lunit.exam.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.lunit.exam.domain.Account;
import io.lunit.exam.domain.History;
import io.lunit.exam.domain.Slide;
import io.lunit.exam.domain.mapping.ForSearchHistoryMapping;
import io.lunit.exam.dto.Analysis;
import io.lunit.exam.dto.Grid;
import io.lunit.exam.repository.AccountRepository;
import io.lunit.exam.repository.HistoryRepository;
import io.lunit.exam.repository.SlideRepository;
import io.lunit.exam.service.HistoryService;
import org.apache.tomcat.util.json.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
