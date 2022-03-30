package ccit.js1842.wxf.dao.impl;

import ccit.js1842.wxf.dao.UserDao;
import org.junit.jupiter.api.Test;

class UserDaoImplTest {

    @Test
    void queryUserByUsernameAndPassword() {
        UserDao userDao = new UserDaoImpl();
        System.out.println(userDao.queryUserByUsernameAndPassword("wuxuefu", "1807521122").toString());

    }
}