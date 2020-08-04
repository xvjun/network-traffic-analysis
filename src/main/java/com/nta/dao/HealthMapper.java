package com.nta.dao;

import com.nta.model.response.Result;
import com.nta.model.response.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.main.MainResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Repository
@Slf4j
public class HealthMapper {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    public Result info(){
        MainResponse info = null;
        try {
            info = restHighLevelClient.info();
        } catch (IOException e) {
            log.error("get es info error");
            e.printStackTrace();
            return Result.failure("get es info error");
        }
        Map infoMap = new HashMap();
        infoMap.put("NodeName", info.getNodeName());
        infoMap.put("ClusterUuid", info.getClusterUuid());
        infoMap.put("ClusterName", info.getClusterName().toString());
        infoMap.put("Version", info.getVersion().toString());
        return Result.success(infoMap);
    }

    public Result ping(){
        boolean stat;
        try {
            stat = restHighLevelClient.ping();
        } catch (IOException e) {
            log.error("es ping error");
            e.printStackTrace();
            return Result.failure("es ping error");
        }
        return Result.success(stat);
    }

}
