package ccit.js1842.wxf.dao.impl;

import ccit.js1842.wxf.bean.CartItemBean;
import ccit.js1842.wxf.dao.CartDao;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

class CartDaoImplTest {

    CartItemBean cartItemBean = new CartItemBean(1, "w", 11, new BigDecimal("0.1"), new BigDecimal(121));
    Integer uId = 1;
    CartDao cartDao = new CartDaoImpl();

    @Test
    void addItem() {

    }

    @Test
    void deleteItem() {
        cartDao.deleteItem(1, 1);
    }

    @Test
    void clear() {
        cartDao.clear(1);
    }

    @Test
    void updateCount() {
        List<CartItemBean> list = cartDao.queryCart(1);
        System.out.println(list);
    }

}