package ccit.js1842.wxf.web;

import ccit.js1842.wxf.bean.GoodsBean;
import ccit.js1842.wxf.bean.PageBean;
import ccit.js1842.wxf.service.GoodsService;
import ccit.js1842.wxf.service.impl.GoodsServiceIml;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ClientGoodsServlet", value = "/ClientGoodsServlet")
public class ClientGoodsServlet extends BaseServlet {
    private GoodsService goodsService = new GoodsServiceIml();


    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
        PageBean<GoodsBean> pageBean = goodsService.page(pageNo, pagesSize);
        pageBean.setUrl("ClientGoodsServlet?action=page");
        request.setAttribute("page", pageBean);
        request.getRequestDispatcher("/client/index.jsp").forward(request, response);
    }
}
