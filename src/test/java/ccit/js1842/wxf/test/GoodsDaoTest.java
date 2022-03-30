package ccit.js1842.wxf.test;

import ccit.js1842.wxf.bean.GoodsBean;
import ccit.js1842.wxf.dao.GoodsDao;
import ccit.js1842.wxf.dao.impl.GoodsDaoImpl;
import org.junit.jupiter.api.Test;

class GoodsDaoTest {

    private GoodsDao goodsDao = new GoodsDaoImpl();

    @Test
    void addGoods() {
        goodsDao.addGoods(new GoodsBean(null, "hp", 6000, 1000, null));
    }

    @Test
    void deleteGoods() {
        goodsDao.deleteGoods(1);
    }

    @Test
    void updateGoods() {
        goodsDao.updateGoods(new GoodsBean(1, "huawei", 6000, 1000, null));
    }

    @Test
    void queryGoodsById() {
        System.out.println(goodsDao.queryGoodsById(1));
    }

    @Test
    void queryGoods() {
        for (GoodsBean queryGood : goodsDao.queryGoods()) {
            System.out.println(queryGood);
        }
    }

    @Test
    void queryForPageTotalCount() {
        for (GoodsBean goodsBean : goodsDao.queryForPageItem(4, 4)) {
            System.out.println(goodsBean);
        }
    }

}