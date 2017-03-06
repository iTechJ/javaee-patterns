package by.itechart.tutorial.viewhelper.advanced;

import by.itechart.tutorial.model.PageData;
import by.itechart.tutorial.model.PageSpecification;
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
        new BusinessService2().performSomeAction(request, response);
        request.setAttribute("title", "Facade - Advanced Страница 3");
        request.setAttribute("data", new PageData("Представление 3", "Некоторый контент специфический для этой advanced страницы"));
        request.setAttribute("page", new PageSpecification("/WEB-INF/common/footer.jsp", "/WEB-INF/common/header.jsp", "/WEB-INF/contents/advanced/page3.jsp"));
        request.getRequestDispatcher("/WEB-INF/common/layout.jsp").forward(request, response);
    }
}
