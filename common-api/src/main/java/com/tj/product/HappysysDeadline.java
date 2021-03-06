package com.tj.product;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;

import java.io.Serializable;

/**
 * @program: HappySys
 * @Date: 2019/7/27 11:39
 * @Author: Mr.Deng
 * @Description:
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class HappysysDeadline  implements Serializable {

 @TableId
 private Integer deadlineId;
 private Integer deadlineDays;         //真实天数
 private String deadlineTime;          //显示的值
 private Double deadlinePrice;        //价格

 @TableField(exist = false)
 private String title;

 public void setTitle(String title) {
  this.title = deadlineTime;
 }
}
