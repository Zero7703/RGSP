package com.rg.thirdpart.hik.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 剩余停车位响应实体
 *
 * @author Harry
 * @date 2022/4/20 21:46
 */
public class PmsParkRemainInfo {

    /**
     * 停车库唯一标识码
     */
    private String parkSyscode;

    /**
     * 停车库名称
     */
    private String parkName;

    /**
     * 父停车库唯一标识
     */
    private String parentParkSyscode;

    /**
     * 停车库车位总数
     */
    private int totalPlace;

    /**
     * 停车库固定车位总数
     */
    private int totalPermPlace;

    /**
     * 停车库预约车位总数
     */
    private int totalReservePlace;

    /**
     * 停车库车位剩余数
     */
    private int leftPlace;

    /**
     * 停车库固定车位剩余数
     */
    private int leftPermPlace;

    /**
     * 停车库预约车位剩余数
     */
    private int leftReservePlace;

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

    public String getParentParkSyscode() {
        return parentParkSyscode;
    }

    public void setParentParkSyscode(String parentParkSyscode) {
        this.parentParkSyscode = parentParkSyscode;
    }

    public int getTotalPlace() {
        return totalPlace;
    }

    public void setTotalPlace(int totalPlace) {
        this.totalPlace = totalPlace;
    }

    public int getTotalPermPlace() {
        return totalPermPlace;
    }

    public void setTotalPermPlace(int totalPermPlace) {
        this.totalPermPlace = totalPermPlace;
    }

    public int getTotalReservePlace() {
        return totalReservePlace;
    }

    public void setTotalReservePlace(int totalReservePlace) {
        this.totalReservePlace = totalReservePlace;
    }

    public int getLeftPlace() {
        return leftPlace;
    }

    public void setLeftPlace(int leftPlace) {
        this.leftPlace = leftPlace;
    }

    public int getLeftPermPlace() {
        return leftPermPlace;
    }

    public void setLeftPermPlace(int leftPermPlace) {
        this.leftPermPlace = leftPermPlace;
    }

    public int getLeftReservePlace() {
        return leftReservePlace;
    }

    public void setLeftReservePlace(int leftReservePlace) {
        this.leftReservePlace = leftReservePlace;
    }
}
