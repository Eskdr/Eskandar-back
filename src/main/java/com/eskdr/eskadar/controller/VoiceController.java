package com.eskdr.eskadar.controller;

import com.eskdr.eskadar.data.User;
import model.SearchVO;
import org.apache.tomcat.jni.FileInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;

@RestController
@RequestMapping("/voice")
public class VoiceController {

    @Autowired
    private ServletContext context;


    @GetMapping("")
    public SearchVO saveVoice(SearchVO searchVO) {
        int writeNum = 0;
        String userId = searchVO.getId();
        boolean secret = searchVO.isSecret();

        User user = new User();

        //writeNum = login(userId);
        secret = true;

        if (secret) {
            if (writeNum > 0) {
                //TODO(@js : 횟수 제한 구현)
            } else {
                //TODO(@js)
            }
        }

        return searchVO;
    }


    @PostMapping(value = "/upload", headers = ("content-type=multipart/*" ))
    public ResponseEntity<FileInfo> upload(@RequestParam("file") MultipartFile inputFile) {

        FileInfo fileInfo = new FileInfo();
        HttpHeaders headers = new HttpHeaders();
        if (!inputFile .isEmpty()) {
            try {
                String oriFileNm = inputFile.getOriginalFilename();
                File destinationFile = new File(context.getRealPath("/WEB-INF/uploaded" ) + File.separator + oriFileNm);
                inputFile.transferTo(destinationFile );
                headers.add("File Uploaded Successfully - ", oriFileNm);
                fileInfo.fname = destinationFile .getPath();
                fileInfo.size=inputFile .getSize();
                return new ResponseEntity<FileInfo>(fileInfo , headers, HttpStatus.OK );

            } catch (Exception e ) {
                return new ResponseEntity<FileInfo>(HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<FileInfo>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("")
    public SearchVO searchVocie(SearchVO searchVO) {
        return searchVO;
    }
}
