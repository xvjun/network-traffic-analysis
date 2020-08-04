package com.nta.controller;

import com.nta.model.response.Result;
import com.nta.service.IHealthService;
import com.nta.service.impl.HealthServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/health")
public class HealthController {

    @Autowired
    private IHealthService healthService;

    @GetMapping("/info")
    public Result info(){
        return healthService.info();
    }

    @GetMapping("/ping")
    public Result ping(){
        return healthService.ping();
    }

}
