package com.tj.product;

import com.baomidou.mybatisplus.annotation.TableName;
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

    private Integer sectionId;
    private Integer sectionMin;
    private Integer sectionMax;

}
