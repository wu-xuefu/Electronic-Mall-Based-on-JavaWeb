package ccit.js1842.wxf.web;

import ccit.js1842.wxf.bean.CartItemBean;
import ccit.js1842.wxf.bean.GoodsBean;
import ccit.js1842.wxf.bean.PageBean;
import ccit.js1842.wxf.bean.UserBean;
import ccit.js1842.wxf.service.CartService;
import ccit.js1842.wxf.service.GoodsService;
import ccit.js1842.wxf.service.impl.CartServiceIml;
import ccit.js1842.wxf.service.impl.GoodsServiceIml;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet(name = "CartServlet", value = "/CartServlet")
public class CartServlet extends BaseServlet {
    private CartService cartService = new CartServiceIml();
    private GoodsService goodsService = new GoodsServiceIml();

    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserBean userBean = (UserBean) request.getSession().getAttribute("user");
        Integer id = Integer.valueOf(request.getParameter("id"));
        Integer count = 1;//Integer.valueOf(request.getParameter("count"));
        GoodsBean goodsBean = goodsService.queryGoodsById(id);
        if (goodsBean == null) {
            request.getRequestDispatcher("/GoodsServlet?action=page").forward(request, response);
        } else {
            cartService.addCart(id, userBean.getId(), count);
            request.getRequestDispatcher("/CartServlet?action=page").forward(request, response);
        }
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserBean userBean = (UserBean) request.getSession().getAttribute("user");
        Integer id = Integer.valueOf(request.getParameter("id"));
        cartService.deleteCartById(id, userBean.getId());
        request.getRequestDispatcher("/CartServlet?action=page").forward(request, response);
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserBean userBean = (UserBean) request.getSession().getAttribute("user");
        Integer id = Integer.valueOf(request.getParameter("id"));
        Integer count = Integer.valueOf(request.getParameter("count"));

        cartService.updateCart(id, count, userBean.getId());

        request.getRequestDispatcher("/CartServlet?action=page").forward(request, response);

    }

    protected void clear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserBean userBean = (UserBean) request.getSession().getAttribute("user");
        cartService.clearCart(userBean.getId());
        request.getRequestDispatcher("/ClientGoodsServlet?action=page").forward(request, response);
    }

    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        Integer uId = Integer.valueOf(request.getParameter("uId"));
        UserBean userBean = (UserBean) request.getSession().getAttribute("user");
        int pageNo;
        if (null == request.getParameter("pageNo")) {
            pageNo = 1;
        } else {
            pageNo = Integer.parseInt(request.getParameter("pageNo"));
        }
        int pagesSize;
        if (null == request.getParameter("pageSize")) {
            pagesSize = PageBean.PAGE_SIZE;
        } else {
            pagesSize = Integer.parseInt(request.getParameter("pageSize"));
        }
        PageBean<CartItemBean> pageBean = cartService.page(pageNo, pagesSize, userBean.getId());
        BigDecimal totalPrice = cartService.totalPrice(userBean.getId());
        Integer totalCount;
        if (totalPrice != null) {
            totalCount = cartService.totalCount(userBean.getId());
        } else {
            totalPrice = new BigDecimal(0);
            totalCount = 0;
        }
        pageBean.setUrl("CartServlet?action=page");
        request.setAttribute("page", pageBean);
        request.setAttribute("totalPrice", totalPrice);
        request.setAttribute("totalCount", totalCount);
        request.getRequestDispatcher("/Cart.jsp").forward(request, response);
    }

}
