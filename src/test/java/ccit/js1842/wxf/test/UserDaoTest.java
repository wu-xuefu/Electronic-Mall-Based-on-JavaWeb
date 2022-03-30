package ccit.js1842.wxf.test;

import ccit.js1842.wxf.dao.UserDao;
import ccit.js1842.wxf.dao.impl.UserDaoImpl;
import org.junit.jupiter.api.Test;

class UserDaoTest {

    @Test
    void queryUserByUsername() {
        UserDao userDao = new UserDaoImpl();
        System.out.println(userDao.queryUserByUsername("wuxuefu"));
    }

    @Test
    void queryUserByUsernameAndPassword() {
        UserDao userDao = new UserDaoImpl();
        if (userDao.queryUserByUsernameAndPassword("wuxuefu", "1807521122") == null)
            System.out.println("yse");
        else {
            System.out.println("no");
        }
    }

    @Test
    void saveUser() {
        UserDao userDao = new UserDaoImpl();
        userDao.createCartTrigger(6);
    }
}