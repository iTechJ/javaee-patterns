package by.itechart.tutorial;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        processRequest(req, res);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException  {
        processRequest(req, res);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        fetchPageDataFromDatabase(request, response);
        performSomeAdditionalProcessing(request, response);
        request.setAttribute("title", "Intercepting Filter");
        request.setAttribute("data", new PageData("Список фильтров этого примера", " 1 - Фильтр, устанавливающий кодировку для RQ/RS. 2 - Фильтр, осуществляюший логгирование RQ/RS. 3- Перенаправление на другие URL\n"));
        request.getRequestDispatcher("/WEB-INF/welcome.jsp").forward(request, response);;
    }

    private void fetchPageDataFromDatabase(HttpServletRequest request, HttpServletResponse response) {
        //Different queries to databases or web services here
    }

    private void performSomeAdditionalProcessing(HttpServletRequest request, HttpServletResponse response) {
        //Page business logic here
    }
}
