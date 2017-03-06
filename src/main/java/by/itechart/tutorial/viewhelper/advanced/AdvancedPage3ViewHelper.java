package by.itechart.tutorial.viewhelper.advanced;

import by.itechart.tutorial.dto.*;
import by.itechart.tutorial.services.BusinessService1;
import by.itechart.tutorial.services.BusinessService2;
import by.itechart.tutorial.viewhelper.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdvancedPage3ViewHelper implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        Service2Params params = new Service2Params(request.getParameter("start"),request.getParameter("end"));
        Service2Result result = new BusinessService2().performSomeAction(params);
        request.setAttribute("result", result);
        request.setAttribute("title", "DAO - Advanced Страница 3");
        request.setAttribute("data", new PageData("Представление 3", "Некоторый контент специфический для этой advanced страницы"));
        request.setAttribute("page", new PageSpecification("/WEB-INF/common/footer.jsp", "/WEB-INF/common/header.jsp", "/WEB-INF/contents/advanced/page3.jsp"));
        request.getRequestDispatcher("/WEB-INF/common/layout.jsp").forward(request, response);
    }
}
