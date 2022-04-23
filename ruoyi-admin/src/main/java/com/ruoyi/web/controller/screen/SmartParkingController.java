package com.ruoyi.web.controller.screen;

import com.rg.thirdpart.hik.service.SmartParkingService;
import com.ruoyi.common.core.domain.AjaxResult;
import io.swagger.annotations.ApiOperation;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 通用请求处理
 *
 * @author ruoyi
 */
@RestController
@RequestMapping("/screen/smartParking")
public class SmartParkingController
{
    private static final Logger log = LoggerFactory.getLogger(SmartParkingController.class);

    @Autowired
    private SmartParkingService smartParkingService;



    @ApiOperation(value = "查询过车记录", httpMethod = "POST", response = String.class, produces = "application/json")
    @RequestMapping(value = "/getCrossRecordsInfo", method = RequestMethod.POST, produces = "application/json")
    public AjaxResult getCrossRecordsInfo( ) {

        try {
            Map<String,Object> result = smartParkingService.getSmartParkingData();
            AjaxResult rep = AjaxResult.success(result);
            return rep;
        } catch (Exception e) {
            e.printStackTrace();
            AjaxResult rep = AjaxResult.error("失败");
            return rep;
        }

    }


}
