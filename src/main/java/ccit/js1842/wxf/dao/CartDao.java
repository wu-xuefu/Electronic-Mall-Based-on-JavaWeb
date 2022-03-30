package ccit.js1842.wxf.dao;

import ccit.js1842.wxf.bean.CartItemBean;

import java.math.BigDecimal;
import java.util.List;

public interface CartDao {
    public int addItem(Integer id, Integer uId, Integer count);

    public int deleteItem(Integer id, Integer uId);

    public int clear(Integer uId);

    public int updateCount(Integer id, Integer count, Integer uId);

    public CartItemBean queryCartById(Integer id, Integer uId);

    public Integer queryForPageTotalCount(Integer uId);

    public List<CartItemBean> queryForPageItem(int begin, int pageSize, Integer uId);

    public BigDecimal queryTotalPrice(Integer uId);

    public Integer queryTotalCount(Integer uId);

    public List<CartItemBean> queryCart(Integer uId);
}
