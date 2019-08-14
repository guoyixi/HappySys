package com.tj.product;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;

import java.io.Serializable;

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
public class HappysysSectionList implements Serializable{
 @TableId
 private Integer sectionListId;
 private String sectionListName;
}
