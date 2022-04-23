package com.rg.thirdpart.hik.bean.request;

import com.rg.thirdpart.hik.config.RunnerConfig;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 *
 *
 * @author Harry
 * @date 2022/4/20 21:20
 */
@ApiModel(value = "车位剩余信息查询",description = "描述")

public class ParkRemainInfoRequest {

    @ApiModelProperty(value="停车库唯一识别码")
    private String parkSyscode;


    /**
     * 查询停车库剩余车位数 URI
     */
    public static final String URI = RunnerConfig.ARTEMIS_PATH.concat("/api/pms/v1/park/remainSpaceNum");

    public static String getURI() {
        return URI;
    }


    public String getParkSyscode() {
        return parkSyscode;
    }

    public void setParkSyscode(String parkSyscode) {
        this.parkSyscode = parkSyscode;
    }
}
