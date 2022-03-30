package ccit.js1842.wxf.service.impl;

import ccit.js1842.wxf.bean.CartItemBean;
import ccit.js1842.wxf.service.CartService;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class CartServiceImlTest {

    CartService cartService = new CartServiceIml();
    CartItemBean cartItemBean = new CartItemBean(3, "w", 11, new BigDecimal("0.1"), new BigDecimal(121));
    Integer uId = 1;

    @Test
    void addCart() {

    }

    @Test
    void deleteCartById() {
        cartService.deleteCartById(1, uId);
    }

    @Test
    void updateCart() {
        cartService.updateCart(2, 1, 1);
    }
}