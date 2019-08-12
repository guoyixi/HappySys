package com.tj.product;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @program: happy
 * @Date: 2019/7/29 0:57
 * @Author: Mr.Deng
 * @Description:
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class HappysysInsuranceSum implements Serializable{

 @TableId
 private Integer insuranceSumId;          //
 private Double insuranceSum;             //保额
 private Double insuranceSumPrice;        //不同保额需要缴纳的费用

 @TableField(exist = false)
 private String title;

 public void setTitle(String title) {
  this.title = String.valueOf(insuranceSum) ;
 }
}
