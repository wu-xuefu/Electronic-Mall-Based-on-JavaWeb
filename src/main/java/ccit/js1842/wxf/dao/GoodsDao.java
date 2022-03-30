package ccit.js1842.wxf.dao;

import ccit.js1842.wxf.bean.GoodsBean;

import java.util.List;

public interface GoodsDao {
    public int addGoods(GoodsBean goods);

    public int deleteGoods(Integer id);

    public int updateGoods(GoodsBean goods);

    public GoodsBean queryGoodsById(Integer id);

    public List<GoodsBean> queryGoods();

    public Integer queryForPageTotalCount();

    public List<GoodsBean> queryForPageItem(int begin, int pageSize);
}
