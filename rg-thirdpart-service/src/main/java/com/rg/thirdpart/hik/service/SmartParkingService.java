package com.rg.thirdpart.hik.service;

import com.google.common.collect.Maps;
import com.rg.thirdpart.hik.bean.PageData;
import com.rg.thirdpart.hik.bean.PmsCrossRecordsInfo;
import com.rg.thirdpart.hik.bean.PmsParkRemainInfo;
import com.rg.thirdpart.hik.bean.request.ParkRemainInfoRequest;
import com.rg.thirdpart.hik.bean.request.PmsCrossRecordsListRequest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import org.apache.commons.compress.utils.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 *
 * @author Harry
 * @date 2022/4/23 20:40
 */
@Service
public class SmartParkingService {

    @Autowired
    private PmsParkService pmsParkService;


    /**
     * 获取智慧停车数据
     * @return
     */
    public Map<String,Object> getSmartParkingData() {
        Map<String,Object> resultData = Maps.newHashMap();
        //1.获取车位总及余量信息 及当前压力值(已停车位/总停车位)
        ParkRemainInfoRequest parkRemainInfoRequest = new ParkRemainInfoRequest();
        List<PmsParkRemainInfo> pmsParkRemainInfoList = pmsParkService.getPmsParkRemainInfo(parkRemainInfoRequest);
        //当前只有一个停车库所以只获取当前停车库数据
        Map<String,Object> overview = Maps.newHashMap();
        PmsParkRemainInfo pmsParkRemainInfo = pmsParkRemainInfoList.get(0);
        overview.put("overage",pmsParkRemainInfo.getLeftPlace());
        int total = pmsParkRemainInfo.getTotalPlace();
        overview.put("total",pmsParkRemainInfo.getTotalPlace());
        int usedCount = pmsParkRemainInfo.getTotalPlace() - pmsParkRemainInfo.getLeftPlace();
        overview.put("used",usedCount);
        overview.put("overload",usedCount / total * 100);
        //2.获取0-当前时间点出入车辆数量，及计算出入车辆高峰期
        //构建请求对象
        PmsCrossRecordsListRequest pmsCrossRecordsListRequest = new PmsCrossRecordsListRequest();
        pmsCrossRecordsListRequest.setPageNo(1);
        pmsCrossRecordsListRequest.setPageSize(1000);
        Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        List<Map<String,Object>> parkingTrend = Lists.newArrayList();
        int maxCount = 0;
        for(int i = 0; i <= hour; i++) {
            Map<String,Object> crossData = Maps.newHashMap();
            crossData.put("time",i < 10 ? "0" + i : String.valueOf(i));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
            c.set(Calendar.HOUR_OF_DAY,i);
            c.set(Calendar.MINUTE,0);
            c.set(Calendar.SECOND,0);
            String startTime = sdf.format(c.getTime());
            c.set(Calendar.HOUR_OF_DAY, i + 1);
            String endTime = sdf.format(c.getTime());
            pmsCrossRecordsListRequest.setStartTime(startTime);
            pmsCrossRecordsListRequest.setEndTime(endTime);
            PageData<PmsCrossRecordsInfo> data = pmsParkService.getPmsCrossRecordslist(pmsCrossRecordsListRequest);
            int comeInCount = (int) data.getList().stream().filter(item -> item.getVehicleOut() == 0)
                .count();
            int leaveCount = (int) data.getList().stream().filter(item -> item.getVehicleOut() == 1)
                .count();
            crossData.put("comeIn",comeInCount);
            crossData.put("leave",leaveCount);
            if(data.getList().size() > maxCount) {
                maxCount = data.getList().size();
                overview.put("peakHours",i);
            }
            parkingTrend.add(crossData);
        }
        resultData.put("overview",overview);
        resultData.put("parkingTrend",parkingTrend);
        return resultData;
    }

}
