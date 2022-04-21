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
@Getter
@Setter
@ToString
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

}
