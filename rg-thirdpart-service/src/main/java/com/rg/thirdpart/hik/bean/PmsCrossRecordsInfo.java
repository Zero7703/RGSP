package com.rg.thirdpart.hik.bean;

import lombok.Getter;
import lombok.Setter;

/**
 *
 *
 * @author Harry
 * @date 2022/4/21 14:37
 */
public class PmsCrossRecordsInfo {

    /**
     * 过车记录唯一标识
     */
    private String crossRecordSyscode;

    /**
     * 停车库唯一标识（最大长度64）
     */
    private String parkSyscode;

    /**
     * 停车库名称（最大长度64）
     */
    private String parkName;

    /**
     * 出入口唯一标识（最大长度64）
     */
    private String entranceSyscode;

    /**
     * 出入口名称（最大长度64）
     */
    private String entranceName;

    /**
     * 车道唯一标识
     */
    private String roadwaySyscode;

    /**
     * 车道名称
     */
    private String roadwayName;

    /**
     * 是否出场
     * 0-进场，
     * 1-出场
     */
    private int vehicleOut;

    /**
     * 放行模式
     * 0-禁止放行，1-固定车包期，2-临时车入场，3-预约车入场，10-离线出场，11-缴费出场，12-预付费出场，13-免费出场，30- 非法卡不放行，31-手动放行，32-特殊车辆放行，33-节假日放行，35-群组放行，36-遥控器开闸
     */
    private int releaseMode;

    /**
     * 放行结果
     * 0-未放行
     * 1-正常放行
     * 2-离线放行
     */
    private int releaseResult;

    /**
     * 放行方式
     * 10-未开闸
     * 11-自动开闸
     * 12-人工/人工开闸
     * 13-遥控器开闸
     */
    private int releaseWay;

    /**
     * 放行原因，100-固定车自动放行
     * 101-临时车自动放行
     * 102-预约车自动放行
     * 103-一户多车自动放行
     */
    private int releaseReason;

    /**
     * 车牌号码（最大长度16）
     */
    private String plateNo;

    /**
     * 卡片号码（最大长度32）
     */
    private String cardNo;

    /**
     * 车辆颜色
     * 0：其他颜色；
     * 1：白色；
     * 2：银色；
     * 3：灰色；
     * 4：黑色；
     * 5：红色；
     * 6：深蓝色；
     * 7：蓝色；
     * 8：黄色；
     * 9：绿色；
     * 10：棕色；
     * 11：粉色；
     * 12：紫色’
     */
    private int vehicleColor;

    /**
     * 车辆类型
     * 0：其他车；
     * 1：小型车；
     * 2：大型车；
     * 3：摩托车
     */
    private int vehicleType;

    /**
     * 车牌颜色
     * 0:蓝色,1:黄色,2:白色,3:黑色,4:绿色,5:民航黑色, 255:其他颜色
     */
    private int plateColor;

    /**
     * 车牌类型
     * 0:标准民用车,1:02式民用车,2:武警车,3:警车,4:民用车双行尾牌车,5:使馆车,6:农用车,7:摩托车,8:新能源车,13:军车
     */
    private int plateType;

    /**
     * 车辆分类
     */
    private String carCategory;

    /**
     * 车辆分类名称
     */
    private String carCategoryName;

    /**
     * 车辆图片uri（最大长度256）
     */
    private String vehiclePicUri;

    /**
     * 车牌图片uri（最大长度256）
     */
    private String plateNoPicUri;

    /**
     * 人脸图片uri（最大长度256）
     */
    private String facePicUri;

    /**
     * 图片服务唯一标识（最大长度64）
     */
    private String aswSyscode;

    /**
     * 通过时间ISO8601格式：
     * yyyy-MM-ddTHH:mm:ss+当前时区，例如北京时间：
     * 2018-07-26T15:00:00+08:00
     * 详见ISO8601协议解释
     */
    private String crossTime;

    /**
     * 创建时间
     * ISO8601格式：
     * yyyy-MM-ddTHH:mm:ss+当前时区，例如北京时间：
     * 2018-07-26T15:00:00+08:00
     * 详见ISO8601协议解释
     */
    private String createTime;


    public String getCrossRecordSyscode() {
        return crossRecordSyscode;
    }

    public void setCrossRecordSyscode(String crossRecordSyscode) {
        this.crossRecordSyscode = crossRecordSyscode;
    }

    public String getParkSyscode() {
        return parkSyscode;
    }

    public void setParkSyscode(String parkSyscode) {
        this.parkSyscode = parkSyscode;
    }

    public String getParkName() {
        return parkName;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

    public String getEntranceSyscode() {
        return entranceSyscode;
    }

    public void setEntranceSyscode(String entranceSyscode) {
        this.entranceSyscode = entranceSyscode;
    }

    public String getEntranceName() {
        return entranceName;
    }

    public void setEntranceName(String entranceName) {
        this.entranceName = entranceName;
    }

    public String getRoadwaySyscode() {
        return roadwaySyscode;
    }

    public void setRoadwaySyscode(String roadwaySyscode) {
        this.roadwaySyscode = roadwaySyscode;
    }

    public String getRoadwayName() {
        return roadwayName;
    }

    public void setRoadwayName(String roadwayName) {
        this.roadwayName = roadwayName;
    }

    public int getVehicleOut() {
        return vehicleOut;
    }

    public void setVehicleOut(int vehicleOut) {
        this.vehicleOut = vehicleOut;
    }

    public int getReleaseMode() {
        return releaseMode;
    }

    public void setReleaseMode(int releaseMode) {
        this.releaseMode = releaseMode;
    }

    public int getReleaseResult() {
        return releaseResult;
    }

    public void setReleaseResult(int releaseResult) {
        this.releaseResult = releaseResult;
    }

    public int getReleaseWay() {
        return releaseWay;
    }

    public void setReleaseWay(int releaseWay) {
        this.releaseWay = releaseWay;
    }

    public int getReleaseReason() {
        return releaseReason;
    }

    public void setReleaseReason(int releaseReason) {
        this.releaseReason = releaseReason;
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

    public int getVehicleColor() {
        return vehicleColor;
    }

    public void setVehicleColor(int vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    public int getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(int vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getPlateColor() {
        return plateColor;
    }

    public void setPlateColor(int plateColor) {
        this.plateColor = plateColor;
    }

    public int getPlateType() {
        return plateType;
    }

    public void setPlateType(int plateType) {
        this.plateType = plateType;
    }

    public String getCarCategory() {
        return carCategory;
    }

    public void setCarCategory(String carCategory) {
        this.carCategory = carCategory;
    }

    public String getCarCategoryName() {
        return carCategoryName;
    }

    public void setCarCategoryName(String carCategoryName) {
        this.carCategoryName = carCategoryName;
    }

    public String getVehiclePicUri() {
        return vehiclePicUri;
    }

    public void setVehiclePicUri(String vehiclePicUri) {
        this.vehiclePicUri = vehiclePicUri;
    }

    public String getPlateNoPicUri() {
        return plateNoPicUri;
    }

    public void setPlateNoPicUri(String plateNoPicUri) {
        this.plateNoPicUri = plateNoPicUri;
    }

    public String getFacePicUri() {
        return facePicUri;
    }

    public void setFacePicUri(String facePicUri) {
        this.facePicUri = facePicUri;
    }

    public String getAswSyscode() {
        return aswSyscode;
    }

    public void setAswSyscode(String aswSyscode) {
        this.aswSyscode = aswSyscode;
    }

    public String getCrossTime() {
        return crossTime;
    }

    public void setCrossTime(String crossTime) {
        this.crossTime = crossTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
