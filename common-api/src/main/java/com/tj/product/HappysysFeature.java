package com.tj.product;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class HappysysFeature {

    @TableId
    private Integer featureId;
    private String featureName;
    private Integer featureCategory;

}
