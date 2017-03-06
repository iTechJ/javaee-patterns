package by.itechart.tutorial.viewhelper.basic;

import by.itechart.tutorial.model.PageData;
import by.itechart.tutorial.model.PageSpecification;
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
public class BasicWelcomePageViewHelper implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        new BusinessService1().performSomeAction(request, response);
        request.setAttribute("title", "Session Facade");
        request.setAttribute("data", new PageData("Session Facade", "Паттерн в своем оригинальном виде не используется, но в изменнном виде находит применение в сокрытии деталей бизнес-логики от уровня представляния"));
        request.setAttribute("page", new PageSpecification("/WEB-INF/common/footer.jsp", "/WEB-INF/common/header.jsp", "/WEB-INF/contents/basic/welcome.jsp"));
        request.getRequestDispatcher("/WEB-INF/common/layout.jsp").forward(request, response);
    }
}
