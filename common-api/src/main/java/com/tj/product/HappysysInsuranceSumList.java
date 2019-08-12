package com.tj.product;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;

import java.io.Serializable;

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
public class HappysysInsuranceSumList implements Serializable {

 @TableId
 private Integer insuranceSumListId;
 private String insuranceSumListName;



}
