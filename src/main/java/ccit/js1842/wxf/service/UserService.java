package ccit.js1842.wxf.service;

import ccit.js1842.wxf.bean.UserBean;

public interface UserService {
    /**
     * 注册用户
     *
     * @param user
     */
    public boolean registeredUser(UserBean user);

    /**
     * @param user
     * @return
     */
    public UserBean login(UserBean user);

    public boolean existsUsername(String username);

}
