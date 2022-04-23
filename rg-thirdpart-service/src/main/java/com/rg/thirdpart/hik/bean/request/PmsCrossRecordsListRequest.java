package com.rg.thirdpart.hik.bean.request;

import com.rg.thirdpart.hik.bean.PageQuery;
import com.rg.thirdpart.hik.config.RunnerConfig;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 停车/过车记录表查询实体
 *
 * @author Harry
 * @date 2022/4/21 14:22
 */
@ApiModel(value = "停车过车记录查询",description = "描述")
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
    private Integer vehicleOut;

    @ApiModelProperty(value="车辆类型\n"
        + "0：其他车\n"
        + "1：小型车\n"
        + "2：大型车\n"
        + "3：摩托车",allowableValues = "0,1,2,3")
    private Integer vehicleType;

    @ApiModelProperty(value="放行结果\n"
        + "0-未放行\n"
        + "1-正常放行\n"
        + "2-离线放行",allowableValues = "0,1,2")
    private Integer releaseResult;

    @ApiModelProperty(value="放行方式\n"
        + "10-未开闸\n"
        + "11-自动开闸\n"
        + "12-人工/人工开闸\n"
        + "13-遥控器开闸",allowableValues = "10,11,12,13")
    private Integer releaseWay;

    @ApiModelProperty(value="放行原因\n"
        + "100-固定车自动放行\n"
        + "101-临时车自动放行\n"
        + "102-预约车自动放行\n"
        + "103-一户多车自动放行",allowableValues = "100,101,102,103")
    private Integer releaseReason;

    @ApiModelProperty(value="车辆分类\n"
        + "9-黑名单\n"
        + "10-固定车\n"
        + "11-临时车\n"
        + "12-预约车\n"
        + "14-特殊车",allowableValues = "9,10,11,12,14")
    private String carCategory;


    public String getParkSyscode() {
        return parkSyscode;
    }

    public void setParkSyscode(String parkSyscode) {
        this.parkSyscode = parkSyscode;
    }

    public String getEntranceSyscode() {
        return entranceSyscode;
    }

    public void setEntranceSyscode(String entranceSyscode) {
        this.entranceSyscode = entranceSyscode;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getVehicleOut() {
        return vehicleOut;
    }

    public void setVehicleOut(Integer vehicleOut) {
        this.vehicleOut = vehicleOut;
    }

    public Integer getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(Integer vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Integer getReleaseResult() {
        return releaseResult;
    }

    public void setReleaseResult(Integer releaseResult) {
        this.releaseResult = releaseResult;
    }

    public Integer getReleaseWay() {
        return releaseWay;
    }

    public void setReleaseWay(Integer releaseWay) {
        this.releaseWay = releaseWay;
    }

    public Integer getReleaseReason() {
        return releaseReason;
    }

    public void setReleaseReason(Integer releaseReason) {
        this.releaseReason = releaseReason;
    }

    public String getCarCategory() {
        return carCategory;
    }

    public void setCarCategory(String carCategory) {
        this.carCategory = carCategory;
    }
}
