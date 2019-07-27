package com.tj.product;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class HappysysSection implements Serializable {

    @TableId
    private Integer sectionId;
    private Integer sectionMin;
    private Integer sectionMax;
    private Integer sectionPrice;

}
