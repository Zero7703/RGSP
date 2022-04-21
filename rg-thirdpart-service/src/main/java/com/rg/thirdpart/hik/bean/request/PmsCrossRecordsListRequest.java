package com.rg.thirdpart.hik.bean.request;

import com.rg.thirdpart.hik.bean.PageQuery;
import com.rg.thirdpart.hik.config.RunnerConfig;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.awt.print.Pageable;
import lombok.Getter;
import lombok.Setter;

/**
 * 停车/过车记录表查询实体
 *
 * @author Harry
 * @date 2022/4/21 14:22
 */
@ApiModel(value = "停车过车记录查询",description = "描述")
@Getter
@Setter
public class PmsCrossRecordsListRequest extends PageQuery {

    /**
     * 停车过车记录查询 URI
     */
    public static final String URI = RunnerConfig.ARTEMIS_PATH.concat("/api/pms/v1/crossRecords/page");


    @ApiModelProperty(value="停车库唯一识别码")
    private String parkSyscode;

    @ApiModelProperty(value="出入口唯一标识")
    private String entranceSyscode;

    @ApiModelProperty(value="车牌号（最大长度16）")
    private String plateNo;

    @ApiModelProperty(value="卡号")
    private String cardNo;

    @ApiModelProperty(value="查询开始时间\n"
        + "ISO8601格式：\n"
        + "yyyy-MM-ddTHH:mm:ss+当前时区，例如北京时间：\n"
        + "2018-07-26T15:00:00+08:00")
    private String startTime;

    @ApiModelProperty(value="查询结束时间\n"
        + "ISO8601格式：\n"
        + "yyyy-MM-ddTHH:mm:ss+当前时区，例如北京时间：\n"
        + "2018-07-26T15:00:00+08:00")
    private String endTime;

    @ApiModelProperty(value="进出场标识\n"
        + "0-进场\n"
        + "1-出场",allowableValues = "0,1")
    private int vehicleOut;

    @ApiModelProperty(value="车辆类型\n"
        + "0：其他车\n"
        + "1：小型车\n"
        + "2：大型车\n"
        + "3：摩托车",allowableValues = "0,1,2,3")
    private int vehicleType;

    @ApiModelProperty(value="放行结果\n"
        + "0-未放行\n"
        + "1-正常放行\n"
        + "2-离线放行",allowableValues = "0,1,2")
    private int releaseResult;

    @ApiModelProperty(value="放行方式\n"
        + "10-未开闸\n"
        + "11-自动开闸\n"
        + "12-人工/人工开闸\n"
        + "13-遥控器开闸",allowableValues = "10,11,12,13")
    private int releaseWay;

    @ApiModelProperty(value="放行原因\n"
        + "100-固定车自动放行\n"
        + "101-临时车自动放行\n"
        + "102-预约车自动放行\n"
        + "103-一户多车自动放行",allowableValues = "100,101,102,103")
    private int releaseReason;

    @ApiModelProperty(value="车辆分类\n"
        + "9-黑名单\n"
        + "10-固定车\n"
        + "11-临时车\n"
        + "12-预约车\n"
        + "14-特殊车",allowableValues = "9,10,11,12,14")
    private String carCategory;





}
