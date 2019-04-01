package com.emall.controller;

import com.emall.error.BusinessException;
import com.emall.response.CommonReturnType;
import com.emall.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Statistic")
@CrossOrigin
public class StatisticController {

    @Autowired
    private StatisticService statisticService;

    @RequestMapping(value = "/getStatistic",method = RequestMethod.GET)
    public CommonReturnType getStatistic(){
        try{
            return CommonReturnType.create(statisticService.getStatistics());
        }catch (BusinessException e){
            e.printStackTrace();
            return CommonReturnType.create(e.getErrCode()+":"+e.getErrMsg(),"false");
        }
    }
}
