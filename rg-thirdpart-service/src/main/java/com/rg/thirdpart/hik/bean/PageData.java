package com.rg.thirdpart.hik.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

/**
 *
 *
 * @author Harry
 * @date 2020/8/10 20:36
 */
@ApiModel(value = "分页对象")
public class PageData<T> {
  /**
   * 记录总数
   */
  @ApiModelProperty(value = "总记录数")
  private long  total;

  /**
   * 当前页码
   */
  @ApiModelProperty(value = "当前页码")
  private Integer pageNo;

  /**
   * 分页大小
   */
  @ApiModelProperty(value = "每页大小")
  private Integer pageSize;


  /**
   * 返回数据
   */
  @ApiModelProperty(value = "分页数据")
  List<T> list;

  public long getTotal() {
    return total;
  }

  public void setTotal(long total) {
    this.total = total;
  }

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

  public List<T> getList() {
    return list;
  }

  public void setList(List<T> list) {
    this.list = list;
  }
}
