package com.tj.product;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;
import lombok.experimental.Accessors;

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
public class HappysysInsuranceSum {

 @TableId
 private Integer insuranceSumId;
 private Integer insuranceSum;
 private Integer insuranceSumPrice;

}
