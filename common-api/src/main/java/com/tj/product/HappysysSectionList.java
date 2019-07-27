package com.tj.product;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;

/**
 * @program: HappySys
 * @Date: 2019/7/27 11:41
 * @Author: Mr.Deng
 * @Description:
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class HappysysSectionList {
 @TableId
 private Integer insuranceListId;
 private String insuranceListName;
}
