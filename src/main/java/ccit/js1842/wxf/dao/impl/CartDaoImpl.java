package ccit.js1842.wxf.dao.impl;

import ccit.js1842.wxf.bean.CartItemBean;
import ccit.js1842.wxf.dao.CartDao;
import ccit.js1842.wxf.utils.MathUtils;

import java.math.BigDecimal;
import java.util.List;

public class CartDaoImpl extends BaseDao implements CartDao {
    @Override
    public int addItem(Integer id, Integer uId, Integer count) {
        String sql = "insert into t_cart_" + uId + "(`id`,`name`,`count`,`price`)values(?,?,?,?)";
        return update(sql, id, "商品信息错误", count, 0);
    }

    @Override
    public int deleteItem(Integer id, Integer uId) {
        String sql = "delete from t_cart_" + uId + " where id = ?";
        return update(sql, id);
    }

    @Override
    public int clear(Integer uId) {
        String sql = "truncate table t_cart_" + uId;
        return execute(sql);
    }

    @Override
    public int updateCount(Integer id, Integer count, Integer uId) {
        String sql = "update t_cart_" + uId + " set count = ? where id = ?";
        return update(sql, count, id);
    }

    @Override
    public CartItemBean queryCartById(Integer id, Integer uId) {
        String sql = "select * from t_cart_" + uId + " where id = ?";
        return queryForOne(CartItemBean.class, sql, id);
    }

    @Override
    public Integer queryForPageTotalCount(Integer uId) {
        String sql = "select count(*) from t_cart_" + uId;
        Number count = (Number) queryForSingleVale(sql);
        return count.intValue();
    }

    @Override
    public List<CartItemBean> queryForPageItem(int begin, int pageSize, Integer uId) {
        String sql = "select * from t_cart_" + uId + " limit ?,?";
        return queryForList(CartItemBean.class, sql, begin, pageSize);
    }

    @Override
    public BigDecimal queryTotalPrice(Integer uId) {
        String sql = "select sum(price) from t_cart_" + uId;
        return MathUtils.getBigDecimal(queryForSingleVale(sql));
    }

    @Override
    public Integer queryTotalCount(Integer uId) {
        String sql = "select sum(count) from t_cart_" + uId;
        Number number = (Number) queryForSingleVale(sql);
        return number.intValue();
    }

    @Override
    public List<CartItemBean> queryCart(Integer uId) {
        String sql = "select * from t_cart_" + uId;
        return queryForList(CartItemBean.class, sql);
    }
}
