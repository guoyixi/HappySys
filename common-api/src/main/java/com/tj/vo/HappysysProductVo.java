package com.tj.vo;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class HappysysProductVo {
    private String productTitle;
    private Double productPrice;
    private String productImage;
    private String productSectionList;
    private String  productDeadlineList;
    private String productInsuranceSumList;
    private String productFeatureList;
    private String productInsuranceList;
    private Integer productLevel1;
    private Integer productLevel2;
    private Integer productLevel3;
    private String productDetails;

}
