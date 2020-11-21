package com.eskdr.eskadar.controller;

import com.eskdr.eskadar.EskadarApplication;
import com.eskdr.eskadar.data.User;
import model.SearchVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/voice")
public class VoiceController {

    private final User user = EskadarApplication.user;

    @GetMapping("")
    public SearchVO saveVoice(SearchVO searchVO) {
        int writeNum = 0;
        String userId = searchVO.getId();
        boolean secret = searchVO.isSecret();

        writeNum = user.login(userId);
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

    @PostMapping("")
    public SearchVO searchVocie(SearchVO searchVO) {
        return searchVO;
    }
}
