package com.eskdr.eskadar.controller;

import com.eskdr.eskadar.data.User;
import model.SearchVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;

@RestController
@RequestMapping("/voice")
public class VoiceController {

    @Autowired
    private ServletContext context;

    private static org.slf4j.Logger Logger = LoggerFactory.getLogger(LocationController.class)

    @GetMapping("")
    public SearchVO saveVoice(SearchVO searchVO) {
        int writeNum = 0;sdfsdfsdf
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


    @RequestMapping(value="/upload", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody
    ModelAndView upload(MultipartHttpServletRequest request) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");

        Logger.info("test===" + request.getParameter("test"));

        return mv;
    }

    @PostMapping("")
    public SearchVO searchVocie(SearchVO searchVO) {
        return searchVO;
    }
}
