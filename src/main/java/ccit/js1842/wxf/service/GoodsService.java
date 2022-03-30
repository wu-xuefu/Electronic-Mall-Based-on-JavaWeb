package ccit.js1842.wxf.service;

import ccit.js1842.wxf.bean.GoodsBean;
import ccit.js1842.wxf.bean.PageBean;

import java.util.List;

public interface GoodsService {
    public void addGoods(GoodsBean goodsBean);

    public void deleteGoodsById(Integer id);

    public void updateGoods(GoodsBean goodsBean);

    public GoodsBean queryGoodsById(Integer id);

    public List<GoodsBean> queryGoods();

    public PageBean<GoodsBean> page(int pageNo, int pagesSize);
}
