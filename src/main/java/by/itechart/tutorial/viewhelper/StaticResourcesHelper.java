package by.itechart.tutorial.viewhelper;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StaticResourcesHelper implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        ServletContext context = request.getServletContext();
        InputStream is = null;
        OutputStream os = null;
        try {
            is = context.getResourceAsStream(request.getRequestURI());
            os = response.getOutputStream();
            IOUtils.copy(is, os);
        }
        finally {
            if(is != null) {
                is.close();
            }
            if(os != null) {
                os.close();
            }
        }
    }
}
