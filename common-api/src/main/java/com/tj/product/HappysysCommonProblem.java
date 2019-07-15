package com.tj.product;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.Accessors;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
@TableName("happysys_common_problem")
public class HappysysCommonProblem {

    //`commonp_id`,`commonp_product_id`,`commonp_title`,`commonp_answer`

    private Integer commonpId;
    private Integer commonpProductId;
    private String commonpTitle;
    private String commonpAnswer;         //答复



}
