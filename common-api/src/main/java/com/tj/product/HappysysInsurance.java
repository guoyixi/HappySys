package com.tj.product;


import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class HappysysInsurance implements Serializable {


    @TableId
    private Integer insuranceId;
    private String insuranceName;                   //保险名
    private Double insurancePrice;                  //保险价格
    private Double insuranceCompensatePrice;        //保险赔偿价格
    private String insuranceDetails;                //保险详情

}
