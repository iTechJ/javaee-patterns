package by.itechart.tutorial.services;

import by.itechart.tutorial.model.PageData;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by alexander.belyaev on 3/3/2017.
 */
public class Page1ViewHelper implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        System.out.println("=========Page 1 HELPER ===========");
        fetchPageDataFromDatabase(request, response);
        performSomeAdditionalProcessing(request, response);
        request.setAttribute("title", "View Helper - Страница 1");
        request.setAttribute("data", new PageData("Представление 1", "View Helper - это тот компонент, которые отвечает за подготовку данных для страницы. Некорректо обращаться к базе данных, файлам и сторонним сервисам, из JSP или FrontController"));
        request.getRequestDispatcher("/WEB-INF/page1.jsp").forward(request, response);
    }

    private void fetchPageDataFromDatabase(HttpServletRequest request, HttpServletResponse response) {
        //Different queries to databases or web services here
    }

    private void performSomeAdditionalProcessing(HttpServletRequest request, HttpServletResponse response) {
        //Page business logic here
    }
}
