package com.tj.product;

import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("happysys_comment")
public class HappysysComment implements Serializable {

    //`comment_id`,`comment_product_id`,`comment_purpose`,`comment_time`,`comment_grade`,`comment_content`,`comment_user_id`

    @TableId
    private Integer commentId;
    private Integer commentProductId;       //商品id
    private String commentTime;             //时间
    private Integer commentGrade;           //等级
    private String commentContent;          //内容
    private Integer commentOrderId;         //订单id
    private Integer commentUserId;          //用户id


}
