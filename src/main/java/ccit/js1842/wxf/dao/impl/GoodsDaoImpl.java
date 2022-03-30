package ccit.js1842.wxf.dao.impl;

import ccit.js1842.wxf.bean.GoodsBean;
import ccit.js1842.wxf.dao.GoodsDao;

import java.util.List;

public class GoodsDaoImpl extends BaseDao implements GoodsDao {
    @Override
    public int addGoods(GoodsBean goods) {
        String sql = "insert into t_goods(`id`,`name`,`value`,`number`,`img_path`)values(?,?,?,?,?)";
        return update(sql, goods.getId(), goods.getName(), goods.getValue(), goods.getNumber(), goods.getImg_path());
    }

    @Override
    public int deleteGoods(Integer id) {
        String sql = "delete from t_goods where id = ?";
        return update(sql, id);
    }

    @Override
    public int updateGoods(GoodsBean goods) {
        String sql = "update t_goods set `name`=?,`value`=?,`number`=?,`img_path`=? where id =?";
        return update(sql, goods.getName(), goods.getValue(), goods.getNumber(), goods.getImg_path(), goods.getId());

    }

    @Override
    public GoodsBean queryGoodsById(Integer id) {
        String sql = "select `id`,`name`,`value`,`number`,`img_path` from t_goods where id = ?";
        return queryForOne(GoodsBean.class, sql, id);
    }

    @Override
    public List<GoodsBean> queryGoods() {
        String sql = "select `id`,`name`,`value`,`number`,`img_path` from t_goods";
        return queryForList(GoodsBean.class, sql);
    }

    @Override
    public Integer queryForPageTotalCount() {
        String sql = "select count(*) from t_goods";
        Number count = (Number) queryForSingleVale(sql);
        return count.intValue();
    }

    @Override
    public List<GoodsBean> queryForPageItem(int begin, int pageSize) {
        String sql = "select `id`,`name`,`value`,`number`,`img_path` from t_goods limit ?,?";
        return queryForList(GoodsBean.class, sql, begin, pageSize);
    }
}
