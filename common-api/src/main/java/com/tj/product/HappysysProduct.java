package com.tj.product;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.sql.Timestamp;
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
    //`product_id`,`product_title`,`product_price`,`product_iamge`,`product_age`,`product_deadline`
    // ,`product_schema`,`product_details`,`product_level1`,`product_level2`,`product_level3`

    @TableId
    private Integer productId;
    private String productTitle;            //标题
    private Double productPrice;            //价格
    private String productImage;            //主图片
    private Integer productAge;             //年龄
    private Timestamp productDeadline;      //期限

    private Integer productSectionId;       //年龄
    private Integer productFeature;          //特色列表
    private Integer productInsurance;        //保障列表

    private String productDetails;          //描述
    private Integer productLevel1;          //所属1级标题
    private Integer productLevel2;          //所属2级标题
    private Integer productLevel3;          //所属3级标题

    @TableField(exist = false)
    private List<HappysysFeature> productFeatureList;           //特色列表

    @TableField(exist = false)
    private List<HappysysInsurance> productInsuranceList;      //保障列表

    @TableField(exist = false)
    private Integer productShoppingCartId;              //购物车表的id

    @TableField(exist = false)
    private Map<String, Object> productMongoData;     //mongodb里的其余杂项

    @TableField(exist = false)
    private List<HappysysCommonProblem> productCommonProblemList;         //常见问题列表

    @TableField(exist = false)
    private List<HappysysFeature> HappysysFeature;       //特色列表




}
