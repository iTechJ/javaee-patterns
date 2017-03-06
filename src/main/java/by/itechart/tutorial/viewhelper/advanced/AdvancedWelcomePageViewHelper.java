package by.itechart.tutorial.viewhelper.advanced;

import by.itechart.tutorial.dto.*;
import by.itechart.tutorial.services.BusinessService1;
import by.itechart.tutorial.services.BusinessService2;
import by.itechart.tutorial.viewhelper.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by alexander.belyaev on 3/3/2017.
 */
public class AdvancedWelcomePageViewHelper implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        //It's valid to call multiplie services
        Service1Params params1 = new Service1Params(request.getParameter("info"),request.getParameter("version"));
        Service1Result result1 = new BusinessService1().performSomeAction(params1);
        Service2Params params2 = new Service2Params(request.getParameter("start"),request.getParameter("end"));
        Service2Result result2 = new BusinessService2().performSomeAction(params2);

        request.setAttribute("result1", result1);
        request.setAttribute("result2", result2);

        request.setAttribute("title", "Data Transfer Object");
        request.setAttribute("data", new PageData("Data Transfer Object", "Передача данных с одного уровня приложения на другой происходит с помощью DTO"));
        request.setAttribute("page", new PageSpecification("/WEB-INF/common/footer.jsp", "/WEB-INF/common/header.jsp", "/WEB-INF/contents/advanced/welcome.jsp"));
        request.getRequestDispatcher("/WEB-INF/common/layout.jsp").forward(request, response);
    }
}
