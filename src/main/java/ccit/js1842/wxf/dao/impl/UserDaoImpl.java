package ccit.js1842.wxf.dao.impl;

import ccit.js1842.wxf.bean.UserBean;
import ccit.js1842.wxf.dao.UserDao;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public UserBean queryUserByUsername(String username) {
        String sql = "select `id`,`username` from t_user where username = ?";
        return queryForOne(UserBean.class, sql, username);
    }

    @Override
    public UserBean queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select `id`,`username`,`name` from t_user where username = ? and password = ?";
        return queryForOne(UserBean.class, sql, username, password);
    }

    @Override
    public int saveUser(UserBean user) {
        String sql = "insert into t_user(`username`,`password`,`name`) values(?,?,?)";
        return update(sql, user.getUsername(), user.getPassword(), user.getName());
    }

    @Override
    public int createCart(Integer uId) {
        String sql = "create table t_cart_" + uId +
                " (id int not null primary key," +
                " name varchar(100) not null," +
                " count int not null," +
                " price decimal not null);";
        return execute(sql);
    }

    public int createCartTrigger(Integer uId) {
        String sql = "create trigger car_insert_trigger_" + uId +
                "    before  insert on  t_cart_" + uId +
                "    for each row" +
                "    begin" +
                "        set NEW.name = (select name from t_goods where t_goods.id = NEW.id);" +
                "        set NEW.price = (select value from t_goods where t_goods.id = NEW.id);" +
                "    end;";
        return execute(sql);
    }

}
