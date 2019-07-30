package com.tj.product;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
@TableName("happysys_common_problem")
public class HappysysCommonProblem implements Serializable {

    //`commonp_id`,`commonp_product_id`,`commonp_title`,`commonp_answer`

    @TableId
    private Integer commonpId;
    private Integer commonpProductId;      //商品id
    private String commonpTitle;           //问题标题
    private String commonpAnswer;         //答复



}
