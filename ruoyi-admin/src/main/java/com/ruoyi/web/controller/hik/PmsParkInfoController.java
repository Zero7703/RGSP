package com.ruoyi.web.controller.hik;

import com.rg.thirdpart.hik.bean.PmsParkRemainInfo;
import com.rg.thirdpart.hik.bean.request.ParkRemainInfoRequest;
import com.rg.thirdpart.hik.service.PmsParkService;
import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.file.FileUtils;
import io.swagger.annotations.ApiOperation;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 通用请求处理
 *
 * @author ruoyi
 */
@RestController
@RequestMapping("/hik/pmsParkInfo")
public class PmsParkInfoController
{
    private static final Logger log = LoggerFactory.getLogger(PmsParkInfoController.class);

    @Autowired
    private PmsParkService pmsParkService;

    private static final String FILE_DELIMETER = ",";




    @ApiOperation(value = "获取停车位数量信息", httpMethod = "POST", response = String.class, produces = "application/json")
    @RequestMapping(value = "/getPmsParkRemainInfo", method = RequestMethod.POST, produces = "application/json")
    public AjaxResult getPmsParkRemainInfo( @RequestBody @Validated ParkRemainInfoRequest parkRemainInfoRequest ) {

        try {
            PmsParkRemainInfo  info = pmsParkService.getPmsParkRemainInfo(parkRemainInfoRequest);
            AjaxResult rep = AjaxResult.success(info);
            return rep;
        } catch (Exception e) {
            e.printStackTrace();
            AjaxResult rep = AjaxResult.error("失败");
            return rep;
        }

    }


}
