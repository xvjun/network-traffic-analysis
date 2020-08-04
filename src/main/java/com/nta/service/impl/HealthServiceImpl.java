package com.nta.service.impl;

import com.nta.dao.HealthMapper;
import com.nta.model.response.Result;
import com.nta.service.IHealthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class HealthServiceImpl implements IHealthService {

    @Autowired
    private HealthMapper healthMapper;

    @Override
    public Result info() {
        return healthMapper.info();
    }

    @Override
    public Result ping() {
        return healthMapper.ping();
    }
}
