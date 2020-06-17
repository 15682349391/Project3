package com.wangli.filter;

import com.wangli.utils.JDBCUtils;

import javax.servlet.*;
import java.io.IOException;

/**
 * @ProjectName: Project2
 * @Package: com.wangli.filter
 * @ClassName: TransactionFilter
 * @Author: 38272
 * @Description:
 * @Date: 2020/5/10 12:29
 * @Version: 1.0
 */
public class TransactionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {


        try {
            chain.doFilter(request, response);
            JDBCUtils.commitAndClose();
        } catch (Exception e) {
            e.printStackTrace();
            JDBCUtils.rollbackAndClose();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void destroy() {

    }
}
