package com.tj.product;

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class HappysysFootprint implements Serializable {

    //`footprint_id`,`footprint_user_id`,`footprint_product_id`


    private Integer footprintId;
    private Integer footprintUserId;            //userId
    private Integer footprintProductId;         //productId

}
