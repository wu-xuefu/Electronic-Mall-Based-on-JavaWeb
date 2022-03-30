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
import java.util.List;

@WebServlet(name = "GoodsServlet", value = "/GoodsServlet")
public class GoodsServlet extends BaseServlet {

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
        pageBean.setUrl("GoodsServlet?action=page");
        request.setAttribute("page", pageBean);
        request.getRequestDispatcher("/Goods.jsp").forward(request, response);
    }

    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

/*        if(ServletFileUpload.isMultipartContent(request)){
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);

            try {
                List<FileItem> list = servletFileUpload.parseRequest(request);
                for (FileItem fileItem : list) {
                    if (fileItem.isFormField()) {

                    }else {
                        fileItem.write((new File("/")));
                    }
                }

            } catch (FileUploadException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }*/

        String name = request.getParameter("name");
        double vale = Double.parseDouble(request.getParameter("value"));
        Integer number = Integer.valueOf(request.getParameter("number"));

        GoodsBean goodsBean = new GoodsBean(null, name, vale, number, null);
        System.out.println(goodsBean.toString());
        goodsService.addGoods(goodsBean);
        response.sendRedirect(request.getContextPath() + "/GoodsServlet?action=page");
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        goodsService.deleteGoodsById(id);

        response.sendRedirect(request.getContextPath() + "/GoodsServlet?action=page");
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        double vale = Double.parseDouble(request.getParameter("value"));
        Integer number = Integer.valueOf(request.getParameter("number"));

        GoodsBean goodsBean = new GoodsBean(id, name, vale, number, null);

        goodsService.updateGoods(goodsBean);

        response.sendRedirect(request.getContextPath() + "/GoodsServlet?action=page");


    }

    protected void getDate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        GoodsBean goods = goodsService.queryGoodsById(id);
        request.setAttribute("goods", goods);
        request.getRequestDispatcher("/goods_edit1.jsp").forward(request, response);

    }

    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<GoodsBean> goods = goodsService.queryGoods();
        request.setAttribute("goods", goods);
        System.out.println(goods.toString());
        request.getRequestDispatcher("/Goods.jsp").forward(request, response);
    }

}
