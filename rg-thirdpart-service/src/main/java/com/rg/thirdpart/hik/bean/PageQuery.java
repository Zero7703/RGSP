package com.rg.thirdpart.hik.bean;/**
 * @Auther: Harry
 * @Date: 2020/8/10 20:43
 * @Description:
 */

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 *
 *
 * @author Harry
 * @date 2020/8/10 20:43
 */
@ApiModel(value = "分页查询对象")
public class PageQuery {

  /**
   * 监控点编号（通用唯一识别码UUID）
   */
  @ApiModelProperty(value = "第几页",required = true)
  @Min(value = 1,message = "当前页最小 第1页")
  private Integer pageNo;

  @Min(value = 1,message = "每页最小是1个数据")
  @Max(value = 1000,message = "每页大小不能操作100")
  @ApiModelProperty(value = "每页大小",required = true)
  private Integer pageSize;


  public Integer getPageNo() {
    return pageNo;
  }

  public void setPageNo(Integer pageNo) {
    this.pageNo = pageNo;
  }

  public Integer getPageSize() {
    return pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }
}
