package ccit.js1842.wxf.service.impl;

import ccit.js1842.wxf.bean.UserBean;
import ccit.js1842.wxf.service.UserService;
import org.junit.jupiter.api.Test;

class UserServiceImlTest {

    UserService userService = new UserServiceIml();

    @Test
    void registeredUser() {
        userService.registeredUser(new UserBean(7, "wxf112", "123", "kk"));
    }
}