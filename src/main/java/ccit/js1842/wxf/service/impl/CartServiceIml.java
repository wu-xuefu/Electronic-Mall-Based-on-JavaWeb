package ccit.js1842.wxf.service.impl;

import ccit.js1842.wxf.bean.CartItemBean;
import ccit.js1842.wxf.bean.PageBean;
import ccit.js1842.wxf.dao.CartDao;
import ccit.js1842.wxf.dao.impl.CartDaoImpl;
import ccit.js1842.wxf.service.CartService;

import java.math.BigDecimal;
import java.util.List;

public class CartServiceIml implements CartService {
    private CartDao cartDao = new CartDaoImpl();

    @Override
    public void addCart(Integer id, Integer uId, Integer count) {
        CartItemBean cartItemBeanOld = cartDao.queryCartById(id, uId);
        if (cartItemBeanOld == null) {
            cartDao.addItem(id, 1, count);
        } else {
            cartDao.updateCount(cartItemBeanOld.getId(), cartItemBeanOld.getCount() + count, uId);
        }
    }

    @Override
    public void deleteCartById(Integer id, Integer uId) {
        cartDao.deleteItem(id, uId);
    }

    @Override
    public void updateCart(Integer id, Integer count, Integer uId) {
        cartDao.updateCount(id, count, uId);
    }

    @Override
    public CartItemBean queryCartItemById(Integer id, Integer uId) {
        return cartDao.queryCartById(id, uId);
    }

    @Override
    public void clearCart(Integer uId) {
        cartDao.clear(uId);
    }

    @Override
    public PageBean<CartItemBean> page(int pageNo, int pageSize, Integer uId) {
        PageBean<CartItemBean> pageBean = new PageBean<>();

        pageBean.setPageNo(pageNo);
        pageBean.setPageSize(pageSize);

        Integer pageTotalCount = cartDao.queryForPageTotalCount(uId);

        pageBean.setPageTotal(pageTotalCount);

        Integer pageTotal = pageTotalCount / pageSize;

        if ((pageTotalCount % pageSize > 0)) {
            pageTotal += 1;
        }
        pageBean.setPageTotal(pageTotal);
        int begin = (pageBean.getPageNo() - 1) * pageSize;
        List<CartItemBean> items = cartDao.queryForPageItem(begin, pageSize, uId);
        pageBean.setItems(items);
        return pageBean;
    }

    @Override
    public List<CartItemBean> queryCart(Integer uId) {
        return cartDao.queryCart(uId);
    }

    @Override
    public Integer totalCount(Integer uId) {
        return cartDao.queryTotalCount(uId);
    }

    @Override
    public BigDecimal totalPrice(Integer uId) {
        return cartDao.queryTotalPrice(uId);
    }
}
