package ccit.js1842.wxf.dao;


import ccit.js1842.wxf.bean.UserBean;

public interface UserDao {

    /**
     * 根据用户名查询用户信息
     *
     * @param username
     * @return
     */
    public UserBean queryUserByUsername(String username);

    /**
     * 根据用户名查询用户信息
     *
     * @param username
     * @param password
     * @return
     */
    public UserBean queryUserByUsernameAndPassword(String username, String password);

    /**
     * 保存用户信息
     *
     * @param user
     * @return
     */
    public int saveUser(UserBean user);

    public int createCart(Integer uId);

    public int createCartTrigger(Integer uId);
}
