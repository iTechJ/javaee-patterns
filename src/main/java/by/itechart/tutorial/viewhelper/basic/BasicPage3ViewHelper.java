package by.itechart.tutorial.viewhelper.basic;

import by.itechart.tutorial.dto.PageData;
import by.itechart.tutorial.dto.PageSpecification;
import by.itechart.tutorial.dto.Service2Params;
import by.itechart.tutorial.dto.Service2Result;
import by.itechart.tutorial.services.BusinessService2;
import by.itechart.tutorial.viewhelper.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BasicPage3ViewHelper implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Service2Params params2 = new Service2Params(request.getParameter("start"),request.getParameter("end"));
        Service2Result result2 = new BusinessService2().performSomeAction(params2);

        request.setAttribute("result", result2);

        request.setAttribute("title", "DTO - Basic Страница 3");
        request.setAttribute("data", new PageData("Стратегии", "Содержимое страницы"));
        request.setAttribute("page", new PageSpecification("/WEB-INF/common/footer.jsp", "/WEB-INF/common/header.jsp", "/WEB-INF/contents/basic/page3.jsp"));
        request.getRequestDispatcher("/WEB-INF/common/layout.jsp").forward(request, response);
    }
}
