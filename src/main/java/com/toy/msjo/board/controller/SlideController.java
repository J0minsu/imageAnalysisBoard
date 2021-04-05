package io.lunit.exam.controller;


import io.lunit.exam.domain.Account;
import io.lunit.exam.domain.Slide;
import io.lunit.exam.domain.mapping.ForSearchSlideMapping;
import io.lunit.exam.service.SlideService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("/api/slides")
public class SlideController {

    @Autowired
    private SlideService service;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final String FILE_PATH = "/Users/jominsu/Desktop/slideStorage/";


    //account가 다운받을 수 있는 slide list 조회
    @GetMapping()
    public ResponseEntity<List<ForSearchSlideMapping>> downloadableSlides(HttpSession session) {

        logger.info("enter /slides, method = GET : find all slides you have permission ");

        Account account = (Account)session.getAttribute("loginUser");

        ArrayList<ForSearchSlideMapping> slideInfo = service.findSlidesIdAndFileNameByAccount(account);

        return ResponseEntity.ok().body(slideInfo);
    }

    //account가 다운받을 수 있는 slide 파일명 검색
    @GetMapping("/{search}")
    public ResponseEntity<List<ForSearchSlideMapping>> searchSlide(@PathVariable String search, HttpSession session) {

        logger.info("enter /searchHistories, method = GET : search slides by filename, among you have permission");

        Account account = (Account)session.getAttribute("loginUser");

        ArrayList<ForSearchSlideMapping> searchSlides = service.searchSlides(account.getId(), search);

        return ResponseEntity.ok().body(searchSlides);
    }

    //해당 id 의 Slide 다운로드
    @GetMapping(value = "/download/{slideId}" , produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> slideDownload(@PathVariable int slideId, HttpSession session) throws IOException {

        logger.info("enter /searchHistories, method = GET : download slide you have permission by id");

        Account account = (Account)session.getAttribute("loginUser");

        // set slide correct info
        Slide slide = service.download(account.getId(), slideId);

        if(slide == null)
            //일치하는 Slide 없을 때 null 반환
            return ResponseEntity.badRequest().body(null);


        try {
            InputStream imageStram = new FileInputStream(FILE_PATH + slide.getFileName());
                                    //convert InputStram to byte Array
            byte [] imageByteArray = imageStram.readAllBytes();

            imageStram.close();
            //정상적으로 반환
            return ResponseEntity.ok().body(imageByteArray);
        }
        catch (IOException e) {
            return ResponseEntity.badRequest().body(null);
        }


//        File file = new File(FILE_PATH + slide.getFileName());
//        if(file.exists()) {
//
//            String mimeType = URLConnection.guessContentTypeFromName(file.getName());
//
//            if(mimeType == null) {
//                mimeType = "application/octet-stream";
//            }
//
//            response.setContentType(mimeType);
//
//
//            // 브라우저에서 바로 보기 response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));
//            // 다운로드
//            response.setHeader("Content-Disposition", String.format("attachment; filename=\"" + file.getName() + "\""));
//
//            response.setContentLength((int) file.length());
//
//            InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
//
//            FileCopyUtils.copy(inputStream, response.getOutputStream());
//
//            return ResponseEntity.ok().body("Success file download");
//
//        }
//
//        return ResponseEntity.noContent().build();
    }

    @PostMapping()
    public ResponseEntity slideUpload(@RequestParam("file") MultipartFile file, HttpSession session) {

        logger.info("enter /slides, method = POST : upload slide");

        String result = "";

        if(file == null || file.isEmpty()) {
            return ResponseEntity.badRequest().body("File is not found");
        }

        try {
            //file upload
            byte[] bytes = file.getBytes();
            Path path = Paths.get(FILE_PATH + file.getOriginalFilename());
            Files.write(path, bytes);

            Account account = (Account) session.getAttribute("loginUser");

            Slide slide = new Slide(file.getOriginalFilename(), path.toString(), account);

            result = service.save(slide);

            if(!result.equals("Success slide upload!"))
                return ResponseEntity.unprocessableEntity().body(result);

        } catch (IOException e ) {

        }
        return ResponseEntity.ok().body(result);
    }
}
