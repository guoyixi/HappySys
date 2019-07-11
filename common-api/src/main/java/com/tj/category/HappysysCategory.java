package com.tj.category;

import lombok.*;

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
public class HappysysCategory {

 private Integer categoryId; //分类ID
 private String categoryName;//分类名称
 private Integer categoryParentId;//分类父ID
 private Integer categoryType;//分类级别

}
