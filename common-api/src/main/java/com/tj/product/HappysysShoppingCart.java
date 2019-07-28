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
public class HappysysShoppingCart implements Serializable {

    //`shopping_cart_id`,`shopping_cart_user_id`,`shopping_cart_product_id`

    @TableId
    private Integer shoppingCartId;
    private Integer shoppingCartUserId;
    private Integer shoppingCartProductId;



}
