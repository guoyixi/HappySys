package com.tj.product;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;

/**
 * @program: happy
 * @Date: 2019/7/29 0:57
 * @Author: Mr.Deng
 * @Description:
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class HappysysInsuranceSumList {

 @TableId
 private Integer insuranceSumListId;
 private String payment_list_name;


}
