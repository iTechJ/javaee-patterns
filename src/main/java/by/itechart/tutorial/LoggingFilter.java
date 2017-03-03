package by.itechart.tutorial;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;


@WebFilter(filterName="loggingFilter")
public class LoggingFilter implements  Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    private void logResponse(ServletResponse response ) {
        HttpServletResponse httpServletResponse = (HttpServletResponse)response;
        StringBuilder builder = new StringBuilder();

        for(String header : httpServletResponse.getHeaderNames()) {
            String headerValue = httpServletResponse.getHeader(header);
            builder.append("\nHeader " + header + " has value " + headerValue);
        }
        builder.append("\nResponse status is :" + httpServletResponse.getStatus());
        System.out.println(builder.toString());
    }

    private void logRequest(ServletRequest request) {
        HttpServletRequest httpServletRequest = (HttpServletRequest)request;
        Map<String, String[]> params = request.getParameterMap();
        StringBuilder builder = new StringBuilder();
        Enumeration<String> headers = httpServletRequest.getHeaderNames();
        while(headers.hasMoreElements()){
            String header = headers.nextElement();
            String headerValue = httpServletRequest.getHeader(header);
            System.out.println("\nHeader :" + header + ", value: " + headerValue);
            builder.append("\nHeader " + header + " has value " + headerValue);
        }
        builder.append("\nRequest headers are :" + params.size());
        builder.append("\nTotal amount of request parameters is:" + params.size());
        for(String param : params.keySet()) {
            builder.append("\nParameter " + param + " has value " + params.get(param).toString());
        }
        System.out.println(builder.toString());
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("==== Going to log request ====" );
        StringBuilder builder = new StringBuilder();
        System.out.println("==== End ====");
        logRequest(request);
        filterChain.doFilter(request, response);//sends request to next resource
        System.out.println("==== Going to log response ====");
        logResponse(response);
        System.out.println("==== End ====" );

    }

    @Override
    public void destroy() {

    }
}
