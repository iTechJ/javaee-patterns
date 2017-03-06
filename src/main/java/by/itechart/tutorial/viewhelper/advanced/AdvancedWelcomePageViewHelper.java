package by.itechart.tutorial.viewhelper.advanced;

import by.itechart.tutorial.model.PageData;
import by.itechart.tutorial.model.PageSpecification;
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
        System.out.println("=========Advanced Welcome HELPER ===========");
        fetchRealtimeDataFromWebService(request, response);
        request.setAttribute("title", "Application Controller");
        request.setAttribute("data", new PageData("Изменение функция компонентов", "Front-Controller делегировал обработку различных запросов Application Controllerу"));
        request.setAttribute("page", new PageSpecification("/WEB-INF/common/footer.jsp", "/WEB-INF/common/header.jsp", "/WEB-INF/contents/advanced/welcome.jsp"));
        request.getRequestDispatcher("/WEB-INF/common/layout.jsp").forward(request, response);
    }

    private void fetchRealtimeDataFromWebService(HttpServletRequest request, HttpServletResponse response) {
        //Different queries to databases or web viewhelper here
    }
}
