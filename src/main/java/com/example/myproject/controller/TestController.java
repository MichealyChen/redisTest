package com.example.myproject.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.myproject.entity.TestRespVO;
import com.example.myproject.entity.TestVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@RestController
@RequestMapping("/cbs/demo1")
@Slf4j
public class TestController {

    @RequestMapping(value = "/select1", method = RequestMethod.POST)
    public Object selectTest(@RequestBody TestVO vo){

        log.info(JSONObject.toJSONString(vo));

        TestRespVO respVO = new TestRespVO();
        respVO.setEndDate(new Date());
        respVO.setStartDate(new Date());
        LocalDate endDate1 = vo.getEndDate1();
        endDate1.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        respVO.setStartDate1(endDate1);

        respVO.setEndDate1(vo.getStartDate1());

        return respVO;
    }
}
