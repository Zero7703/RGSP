package com.rg.thirdpart.hik.service;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.google.common.collect.Maps;
import com.hikvision.artemis.sdk.ArtemisHttpUtil;
import com.rg.thirdpart.hik.bean.PageData;
import com.rg.thirdpart.hik.bean.PmsCrossRecordsInfo;
import com.rg.thirdpart.hik.bean.PmsParkRemainInfo;
import com.rg.thirdpart.hik.bean.request.ParkRemainInfoRequest;
import com.rg.thirdpart.hik.bean.request.PmsCrossRecordsListRequest;
import com.rg.thirdpart.hik.config.RunnerConfig;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 车位管理服务
 *
 * @author Harry
 * @date 2022/4/20 21:43
 */
@Service
public class PmsParkService extends BaseService{


    /**
     * 获取停车位剩余信息
     * @param parkRemainInfoRequest
     * @return
     */
    public PmsParkRemainInfo getPmsParkRemainInfo(ParkRemainInfoRequest parkRemainInfoRequest) {
        PmsParkRemainInfo pmsParkRemainInfo = new PmsParkRemainInfo();
        Map<String, String> path = Maps.newHashMap();
        path.put(RunnerConfig.getProtocol(), ParkRemainInfoRequest.URI);
        String resultJsonStr = ArtemisHttpUtil
            .doPostStringArtemis(path, JSONObject.toJSONString(parkRemainInfoRequest), null, null, CONTENT_TYPE);
        JSONObject  resultJson = JSONObject.parseObject(resultJsonStr);
        String code  =  resultJson.getString("code");
        if(!REQUEST_OK.equals(code)){
        }else{
            pmsParkRemainInfo = JSONObject.parseObject(resultJson.getString("data"),new TypeReference<PmsParkRemainInfo>(){});
        }
        return pmsParkRemainInfo;
    }



    /**
     * 分页获取 停车过车记录数据，获取出场  是否出场选择1，获取入场 是否出场选择0
     * @param pmsCrossRecordsListRequest
     * @return
     * @throws
     */
    public PageData<PmsCrossRecordsInfo> getPmsCrossRecordslist( PmsCrossRecordsListRequest pmsCrossRecordsListRequest )  {
        PageData<PmsCrossRecordsInfo> pageData = new PageData<>();
        Map<String, String> path = Maps.newHashMap();
        path.put(RunnerConfig.getProtocol(), PmsCrossRecordsListRequest.URI);
        String resultJsonStr = ArtemisHttpUtil
            .doPostStringArtemis(path, JSONObject.toJSONString(pmsCrossRecordsListRequest), null, null, CONTENT_TYPE);
        JSONObject  resultJson = JSONObject.parseObject(resultJsonStr);
        String code  =  resultJson.getString("code");
        if(!REQUEST_OK.equals(code)){
        }else{
            pageData = JSONObject.parseObject(resultJson.getString("data"),new TypeReference<PageData<PmsCrossRecordsInfo>>(){});
        }
        return pageData;
    }


}
