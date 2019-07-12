package com.tj.category;

import lombok.*;

import java.util.List;

/**
 * @program: happysys
 * @Date: 2019/7/11 11:11
 * @Author: Mr.Deng
 * @Description:
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class HappysysCategoryVo {

 private HappysysCategory happysysCategory;
 private List<HappysysCategoryVo> happysysCategoryVos;

}
