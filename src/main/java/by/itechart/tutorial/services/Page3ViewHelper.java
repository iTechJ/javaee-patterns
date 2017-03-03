package by.itechart.tutorial.services;

import by.itechart.tutorial.model.PageData;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Page3ViewHelper implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        System.out.println("=========Page 3 HELPER ===========");
        fetchPageDataFromDatabase(request, response);
        performSomeAdditionalProcessing(request, response);
        request.setAttribute("title", "View Helper  - Страница 3");
        request.setAttribute("data", new PageData("Стратегии", "Не забывайте, что существуют также другие стратегии реализации этого шаблона."));
        request.getRequestDispatcher("/WEB-INF/page3.jsp").forward(request, response);
    }

    private void fetchPageDataFromDatabase(HttpServletRequest request, HttpServletResponse response) {
        //Different queries to databases or web services here
    }

    private void performSomeAdditionalProcessing(HttpServletRequest request, HttpServletResponse response) {
        //Page business logic here
    }
}
