package com.tj.product;


import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;
import lombok.experimental.Accessors;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class HappysysInsurance {

    @TableId
    private Integer insuranceId;
    private String insuranceName;
    private Double insurancePrice;
    private String insuranceDetails;

}
