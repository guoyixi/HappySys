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
public class HappysysProduct implements Serializable {

    @TableId
    private Integer productId;
    private String productTitle;            //标题
    private Double productPrice;            //价格
    private String productImage;            //主图片

    private Integer productDeadline;        //期限列表ID
    private Integer productSection;         //年龄区间ID
    private Integer productFeature;         //特色列表ID
    private Integer productInsurance;       //保障列表ID

    private String productDetails;          //产品描述
    private Integer productLevel1;          //所属1级标题
    private Integer productLevel2;          //所属2级标题
    private Integer productLevel3;          //所属3级标题
    private Integer productClassifyId;      //快选id


    @TableField(exist = false)
    private Integer classify_id;             //快选ID

    @TableField(exist = false)
    private List<HappysysDeadline> productDeadlineList;           //年龄区间

    @TableField(exist = false)
    private List<HappysysSection> productSectionList;           //年龄区间


    @TableField(exist = false)
    private HappysysSection happysysSection;

    @TableField(exist = false)
    private List<HappysysFeature> productFeatureList;           //特色列表

    @TableField(exist = false)
    private List<HappysysInsurance> productInsuranceList;       //保障列表

    @TableField(exist = false)
    private Integer productShoppingCartId;                      //购物车表的id

    @TableField(exist = false)
    private Map<String, Object> productMongoData;               //mongodb里的其余杂项

    @TableField(exist = false)
    private List<HappysysCommonProblem> productCommonProblemList;//常见问题列表



}
