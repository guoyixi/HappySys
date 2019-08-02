package com.tj.product;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;

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
public class HappysysDeadline {

 @TableId
 private Integer deadlineId;
 private String deadlineTime;
 private Integer deadlinePrice;

}
