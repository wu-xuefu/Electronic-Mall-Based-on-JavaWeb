package ccit.js1842.wxf.service.impl;

import ccit.js1842.wxf.bean.UserBean;
import ccit.js1842.wxf.dao.UserDao;
import ccit.js1842.wxf.dao.impl.UserDaoImpl;
import ccit.js1842.wxf.service.UserService;

public class UserServiceIml implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public boolean registeredUser(UserBean user) {
        userDao.saveUser(user);
        UserBean userBean = login(user);
        if (userBean != null) {
            userDao.createCart(userBean.getId());
            userDao.createCartTrigger(userBean.getId());
            return true;
        }
        return false;

    }

    @Override
    public UserBean login(UserBean user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        if (userDao.queryUserByUsername(username) == null) {
            return false;
        }
        return true;
    }
}
