package com.tj.product;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * @program: tj
 * @Date: 2019/7/10 22:19
 * @Author: Mr.Deng
 * @Description:
 */

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class HappysysCategory implements Serializable{

 @TableId
 private Integer categoryId; //分类ID
 private String categoryName;//分类名称
 private Integer categoryParentId;//分类父ID
 private Integer categoryType;//分类级别

 @TableField(exist = false)
 private List<HappysysCategory> happysysCategories;

}
