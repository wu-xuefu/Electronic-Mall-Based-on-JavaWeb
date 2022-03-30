package ccit.js1842.wxf.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

@WebFilter(filterName = "CharacterFilter",
        urlPatterns = "/*",
        initParams = {
                @WebInitParam(name = "charset", value = "utf-8")
        })
public class CharacterFilter implements Filter {
    private String filterName;
    private String charset;

    public void init(FilterConfig config) throws ServletException {
        filterName = config.getFilterName();
        charset = config.getInitParameter("charset");

    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        request.setCharacterEncoding(charset);
        response.setCharacterEncoding(charset);
        chain.doFilter(request, response);
    }
}
