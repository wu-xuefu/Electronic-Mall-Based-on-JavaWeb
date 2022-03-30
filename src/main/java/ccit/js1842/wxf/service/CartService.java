package ccit.js1842.wxf.service;

import ccit.js1842.wxf.bean.CartItemBean;
import ccit.js1842.wxf.bean.PageBean;

import java.math.BigDecimal;
import java.util.List;

public interface CartService {
    public void addCart(Integer id, Integer uId, Integer count);

    public void deleteCartById(Integer id, Integer uId);

    public void updateCart(Integer id, Integer count, Integer uId);

    public void clearCart(Integer uId);

    public CartItemBean queryCartItemById(Integer id, Integer uId);

    public PageBean<CartItemBean> page(int pageNo, int pageSize, Integer uId);

    public List<CartItemBean> queryCart(Integer uId);

    public Integer totalCount(Integer uId);

    public BigDecimal totalPrice(Integer uId);
}
