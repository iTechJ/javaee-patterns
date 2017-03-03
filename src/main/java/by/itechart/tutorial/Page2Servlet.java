package by.itechart.tutorial;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/page3")
public class Page2Servlet extends HttpServlet {

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
        request.setAttribute("title", "Intercepting Filter - Redirect");
        request.setAttribute("data", new PageData("Redirect со старых адресов на новые", "Зачастую необходимо, чтобы устаревшие адреса все равно возвращали контент. Это можно реализовать посредством фильтра. Сервлет, возвративший эту страницу, замаплен на path, отличный от того, что можно видеть в браузере. Фильтр перенаправляет запрос со старого URL на новый."));
        request.getRequestDispatcher("/WEB-INF/page2.jsp").forward(request, response);;
    }

    private void fetchPageDataFromDatabase(HttpServletRequest request, HttpServletResponse response) {
        //Different queries to databases or web services here
    }

    private void performSomeAdditionalProcessing(HttpServletRequest request, HttpServletResponse response) {
        //Page business logic here
    }
}
