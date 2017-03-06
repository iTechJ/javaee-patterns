package by.itechart.tutorial.services;

import by.itechart.tutorial.model.PageData;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by alexander.belyaev on 3/3/2017.
 */
public class WelcomePageViewHelper  implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        System.out.println("=========WELCOME HELPER ===========");
        fetchPageDataFromDatabase(request, response);
        performSomeAdditionalProcessing(request, response);
        request.setAttribute("title", "View Helper");
        request.setAttribute("data", new PageData("Помошник представления, реализованный на стороне сервлета", "Логика, ранее находившаяся во FrontController, теперь была перемещена в отдельные  для каждой страницы"));
        request.getRequestDispatcher("/WEB-INF/welcome.jsp").forward(request, response);
    }

    private void fetchPageDataFromDatabase(HttpServletRequest request, HttpServletResponse response) {
        //Different queries to databases or web services here
    }

    private void performSomeAdditionalProcessing(HttpServletRequest request, HttpServletResponse response) {
        //Page business logic here
    }
}
