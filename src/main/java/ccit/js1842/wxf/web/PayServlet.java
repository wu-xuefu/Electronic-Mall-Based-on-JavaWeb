package ccit.js1842.wxf.web;

import ccit.js1842.wxf.bean.CartItemBean;
import ccit.js1842.wxf.bean.GoodsBean;
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
import java.util.List;

@WebServlet(name = "PayServlet", value = "/PayServlet")
public class PayServlet extends BaseServlet {
    GoodsService goodsService = new GoodsServiceIml();
    CartService cartService = new CartServiceIml();

    protected void pay(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserBean userBean = (UserBean) request.getSession().getAttribute("user");
        List<CartItemBean> list = cartService.queryCart(userBean.getId());
        for (CartItemBean cartItemBean : list) {
            GoodsBean goodsBean = goodsService.queryGoodsById(cartItemBean.getId());
            Integer number = goodsBean.getNumber() - cartItemBean.getCount();
            goodsBean.setNumber(number);
            goodsService.updateGoods(goodsBean);
        }
        cartService.clearCart(userBean.getId());
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
