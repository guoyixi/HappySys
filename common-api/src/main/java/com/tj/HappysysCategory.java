package com.tj;

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

 private Integer categoryId;
 private String categoryName;
 private Integer categoryParentId;
 private Integer categoryType;

}
