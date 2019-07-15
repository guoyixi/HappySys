package com.tj.product;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
@TableName("happysys_product")
public class HappysysPoduct implements Serializable {
    //`product_id`，`product_title`，`product_price`，`product_iamge`，`product_level1`，`product_level2`，`product_level3`，`product_output`

    @TableId
    private Integer productId;
    private String productTitle;
    private String productPrice;
    private String productIamge;
    private Integer productOutput;      //产量
    private Integer productLevel1;
    private Integer productLevel2;
    private Integer productLevel3;

    @TableField(exist = false)
    private Map<String, Object> mongoData;     //mongodb里的其余杂项

    @TableField(exist = false)
    private List<HappysysCommonProblem> commonProblemList;         //常见问题列表






}
