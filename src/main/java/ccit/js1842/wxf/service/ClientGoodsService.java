package ccit.js1842.wxf.service;

import ccit.js1842.wxf.bean.GoodsBean;
import ccit.js1842.wxf.bean.PageBean;

public interface ClientGoodsService {
    public PageBean<GoodsBean> page(int pageNo, int pagesSize);
}
