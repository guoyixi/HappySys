package com.tj.product;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class HappysysOrder implements Serializable {

    //`order_id`,`order_number`,`order_price`,`order_face_amount`,`order_time`,`order_expire_time`,`order_status`
    // ,`order_applicant_id`,`order_recognizee_id`,`order_product_id`,`order_user_id`

    @TableId
    private Integer orderId;
    private String orderNumber;                 //订单号
    private Double orderPrice;                  //总价格
    private Double orderFaceAmount;            //最基本的保额：除所有保险项的保额
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date orderTime;                     //购买日期
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date orderExpireTime;               //到期时间
    private Integer orderStatus;                //状态：1待支付、2待生效、3生效中
    private Integer orderApplicantId;           //投保人id
    private Integer orderRecognizeeId;          //被保人id
    private Integer orderProductId;             //商品id
    private Integer orderUserId;                //用户id

    @TableField(exist = false)
    private List<HappysysOrderDetails> orderDetailsList;

}
