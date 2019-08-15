package com.tj.product;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;

/**
 * @program: HappySys
 * @Date: 2019/8/12 13:10
 * @Author: Mr.Deng
 * @Description:
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class HappysysOrderDetails {

 @TableId
 private Integer orderDetailsId;
 private Integer orderDetailsInsuranceId;
 private Integer orderDetailsOrderId;



}
