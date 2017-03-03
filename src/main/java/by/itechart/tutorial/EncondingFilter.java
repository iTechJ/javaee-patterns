package by.itechart.tutorial;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName="encodingFilter")
public class EncondingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Going to set request encoding");
        request.setCharacterEncoding("UTF-8");
        filterChain.doFilter(request, response);//sends request to next resource
        System.out.println("Going to set response encoding");
        response.setCharacterEncoding("UTF-8");
    }

    @Override
    public void destroy() {

    }
}
