package com.tj.product;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * @program: HappySys
 * @Date: 2019/7/29 0:34
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
public class HappysysPayment {

 @TableId
 private Integer paymentId;
 private String paymentTime;
 private Integer paymentCategory;

}
