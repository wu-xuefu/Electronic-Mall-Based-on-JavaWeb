package ccit.js1842.wxf.service.impl;

import ccit.js1842.wxf.bean.GoodsBean;
import ccit.js1842.wxf.bean.PageBean;
import ccit.js1842.wxf.dao.GoodsDao;
import ccit.js1842.wxf.dao.impl.GoodsDaoImpl;
import ccit.js1842.wxf.service.GoodsService;

import java.util.List;

public class GoodsServiceIml implements GoodsService {

    private GoodsDao goodsDao = new GoodsDaoImpl();

    @Override
    public void addGoods(GoodsBean goodsBean) {
        goodsDao.addGoods(goodsBean);
    }

    @Override
    public void deleteGoodsById(Integer id) {
        goodsDao.deleteGoods(id);
    }

    @Override
    public void updateGoods(GoodsBean goodsBean) {
        goodsDao.updateGoods(goodsBean);
    }


    @Override
    public GoodsBean queryGoodsById(Integer id) {
        return goodsDao.queryGoodsById(id);
    }

    @Override
    public List<GoodsBean> queryGoods() {
        return goodsDao.queryGoods();
    }

    @Override
    public PageBean<GoodsBean> page(int pageNo, int pageSize) {
        PageBean<GoodsBean> pageBean = new PageBean<>();

        pageBean.setPageNo(pageNo);
        pageBean.setPageSize(pageSize);

        Integer pageTotalCount = goodsDao.queryForPageTotalCount();

        pageBean.setPageTotalCount(pageTotalCount);

        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal += 1;
        }
        pageBean.setPageTotal(pageTotal);
        int begin = (pageBean.getPageNo() - 1) * pageSize;
        List<GoodsBean> items = goodsDao.queryForPageItem(begin, pageSize);
        pageBean.setItems(items);


        return pageBean;
    }
}
