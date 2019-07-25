package com.tj.product;


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

    private Integer insuranceId;
    private String insuranceName;
    private Double insurancePrice;


}
