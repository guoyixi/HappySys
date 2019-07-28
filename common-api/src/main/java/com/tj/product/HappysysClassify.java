package com.tj.product;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HappysysClassify {
    //classify_id classify_name classify_parentId
    private int classifyId;             //快选分类id
    private String classifyName;        //快选分类name
    private String classifyParentId;    //快选分类父id

    //对应子类的集合
    @TableField(exist = false)
    private List<HappysysClassify> child;
}
