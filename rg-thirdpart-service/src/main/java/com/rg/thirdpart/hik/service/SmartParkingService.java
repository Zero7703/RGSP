package com.rg.thirdpart.hik.service;

import com.google.common.collect.Maps;
import com.rg.thirdpart.hik.bean.PageData;
import com.rg.thirdpart.hik.bean.PmsCrossRecordsInfo;
import com.rg.thirdpart.hik.bean.PmsParkRemainInfo;
import com.rg.thirdpart.hik.bean.request.ParkRemainInfoRequest;
import com.rg.thirdpart.hik.bean.request.PmsCrossRecordsListRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
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



    public  Map<String,Object> newPage() throws Exception{
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
        PmsCrossRecordsListRequest pmsCrossRecordsListRequest = new PmsCrossRecordsListRequest();
        int pageNo = 0;
        pmsCrossRecordsListRequest.setPageSize(1000);
        Calendar sc = Calendar.getInstance();
        sc.set(Calendar.HOUR_OF_DAY,0);
        sc.set(Calendar.MINUTE,0);
        sc.set(Calendar.SECOND,0);
        Calendar ec = Calendar.getInstance();
        ec.set(Calendar.HOUR_OF_DAY,23);
        ec.set(Calendar.MINUTE,59);
        ec.set(Calendar.SECOND,59);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
        String startTime = sdf.format(sc.getTime());
        String endTime = sdf.format(ec.getTime());
        pmsCrossRecordsListRequest.setStartTime(startTime);
        pmsCrossRecordsListRequest.setEndTime(endTime);
        List<PmsCrossRecordsInfo> list = Lists.newArrayList();
        PageData<PmsCrossRecordsInfo> data = new PageData<>();
        do{
            pageNo ++ ;
            pmsCrossRecordsListRequest.setPageNo(pageNo);
            data = pmsParkService.getPmsCrossRecordslist(pmsCrossRecordsListRequest);
            if(data.getTotal() == 0) {
                break;
            }
            list.addAll(data.getList());
        } while (!(pageNo * 1000 > data.getTotal()));
//        for(;;) {
//
//            list.addAll(data.getList());
//        }
        Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int maxCount = 0;
        List<Map<String,Object>> parkingTrend = Lists.newArrayList();
        for(int i = 0; i <= hour; i++) {
            c.set(Calendar.HOUR_OF_DAY,i);
            c.set(Calendar.MINUTE,0);
            c.set(Calendar.SECOND,0);
            Date sDate = c.getTime();
            c.set(Calendar.MINUTE,59);
            c.set(Calendar.SECOND,59);
            Date eDate = c.getTime();
            Predicate<PmsCrossRecordsInfo> start = (item) -> {
                try {
                    return (sdf.parse(item.getCrossTime()).after(sDate));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return false;
            };
            c.set(Calendar.HOUR_OF_DAY,i+1);
            Predicate<PmsCrossRecordsInfo> end = (item) -> {
                try {
                    return (sdf.parse(item.getCrossTime()).before(eDate));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return false;
            };

            Predicate<PmsCrossRecordsInfo> in = (item) -> item.getVehicleOut() == 0;
            Predicate<PmsCrossRecordsInfo> out = (item) -> item.getVehicleOut() == 1;
            Map<String,Object> crossData = Maps.newHashMap();
            crossData.put("time",i < 10 ? "0" + i : String.valueOf(i));
//            int allCount =(int) list.stream().filter(item -> sdf.parse(item.getCrossTime()).after(sDate)).filter().count();
            int allCount =(int) list.stream().filter(start.and(end)).count();
            int comeInCount = (int) list.stream().filter(start.and(end)).filter(in).count();
            int leaveCount = (int) list.stream().filter(start.and(end)).filter(out).count();
            crossData.put("comeIn",comeInCount);
            crossData.put("leave",leaveCount);
            if(allCount >= maxCount) {
                maxCount = allCount;
                overview.put("peakHours",i);
            }
            parkingTrend.add(crossData);
        }
        resultData.put("overview",overview);
        resultData.put("parkingTrend",parkingTrend);
        return resultData;



    }

}
