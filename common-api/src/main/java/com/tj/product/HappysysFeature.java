package com.tj.product;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;
import org.springframework.boot.ExitCodeEvent;

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

    @TableField(exist = false)
    private String title;

    public void setTitle(String title){
        this.title=featureName;
    }
}
