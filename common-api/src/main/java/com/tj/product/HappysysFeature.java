package com.tj.product;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class HappysysFeature implements Serializable{

    @TableId
    private Integer featureId;
    private String featureName;
    private Integer featureCategory;

}
