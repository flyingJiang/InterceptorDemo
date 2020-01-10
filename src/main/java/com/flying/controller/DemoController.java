package com.flying.controller;


import com.flying.annotation.Auth;
import com.flying.constant.HSHttpCodeEnum;
import com.flying.entity.HSResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/demo")
public class DemoController {
    private static Logger logger = LoggerFactory.getLogger(DemoController.class);

    @Auth("yes")
    @GetMapping("/yes")
    @ResponseBody
    public HSResult<String> yesDemo() {
        logger.info("Yes is going");
        return HSResult.build(HSHttpCodeEnum.CODE_200.getValue(),"ok");
    }

    @Auth("no")
    @GetMapping("/no")
    @ResponseBody
    public HSResult<String> noDemo() {
        logger.info("No is going");
        return HSResult.build(HSHttpCodeEnum.CODE_500.getValue(), "no");
    }
}
