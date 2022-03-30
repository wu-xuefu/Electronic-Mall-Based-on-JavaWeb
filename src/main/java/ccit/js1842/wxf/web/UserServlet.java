package ccit.js1842.wxf.web;

import ccit.js1842.wxf.bean.UserBean;
import ccit.js1842.wxf.service.UserService;
import ccit.js1842.wxf.service.impl.UserServiceIml;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends BaseServlet {
    UserService userService = new UserServiceIml();

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("name");
        String password = request.getParameter("passwd");

        UserBean userBean = new UserBean(null, username, password, null);
        UserBean userBeanLogin = userService.login(userBean);
        if (userBeanLogin == null) {
            response.sendRedirect("index.jsp");
        } else {
            request.getSession().setAttribute("user", userBeanLogin);
            response.sendRedirect(request.getContextPath() + "/GoodsServlet?action=page");

        }
    }

    protected void registered(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("name");
        String password = request.getParameter("passwd");
        String nickname = request.getParameter("nickname");
        UserBean userBean = new UserBean();
        userBean.setUsername(username);
        userBean.setPassword(password);
        userBean.setName(nickname);

        if (userService.existsUsername(username)) {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else {
            userService.registeredUser(userBean);
            request.getSession().setAttribute("user", userBean);
            request.getRequestDispatcher("/GoodsServlet?action=page").forward(request, response);
        }
    }

    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getSession().invalidate();
        response.sendRedirect("/index.jsp");
    }
}