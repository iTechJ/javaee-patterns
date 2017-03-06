package by.itechart.tutorial.viewhelper.advanced;

import by.itechart.tutorial.dto.PageData;
import by.itechart.tutorial.dto.PageSpecification;
import by.itechart.tutorial.dto.Service1Params;
import by.itechart.tutorial.dto.Service1Result;
import by.itechart.tutorial.services.BusinessService1;
import by.itechart.tutorial.viewhelper.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by alexander.belyaev on 3/3/2017.
 */
public class AdvancedPage1ViewHelper implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        Service1Params params = new Service1Params(request.getParameter("info"),request.getParameter("version"));
        Service1Result result = new BusinessService1().performSomeAction(params);
        request.setAttribute("result", result);
        request.setAttribute("title", "DTO - Advanced Страница 1");
        request.setAttribute("data", new PageData("Представление 1", "Некоторый контент специфический для этой advanced страницы"));
        request.setAttribute("page", new PageSpecification("/WEB-INF/common/footer.jsp", "/WEB-INF/common/header.jsp", "/WEB-INF/contents/advanced/page1.jsp"));
        request.getRequestDispatcher("/WEB-INF/common/layout.jsp").forward(request, response);
    }
}
