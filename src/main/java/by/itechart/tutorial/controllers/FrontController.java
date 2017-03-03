package by.itechart.tutorial.controllers;

import by.itechart.tutorial.model.PageData;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/*
 Putting all code into single class is considered to be anti-pattern "Good object"
 We'll show you the proper way of resolving this problem later during this tutorial
 */
@WebServlet("/")
public class FrontController extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        processRequest(req, res);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException  {
        processRequest(req, res);
    }

    /* Front Controller Really serves ALL incoming requests, event for static resources */
    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        makeSomeCommonCalculationsForAllRequests(request);
        if(isStaticResource(request.getRequestURI())) {
            processStaticResource(request, response);
        } else {
            processDynamicResource(request, response);
        }
    }

    private void processStaticResource(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException  {
        ServletContext context = request.getServletContext();
        InputStream is = null;
        OutputStream os = null;
        try {
           is = context.getResourceAsStream(request.getRequestURI());
            os = response.getOutputStream();
            IOUtils.copy(is, os);
        }
        finally {
            if(is != null) {
                is.close();
            }
            if(os != null) {
                os.close();
            }
        }
    }

    //It's not very accurate function actually... just to exemplify the case
    private boolean isStaticResource(String requestedURI) {
        return requestedURI != null && (requestedURI.endsWith(".css") || requestedURI.endsWith(".js"));
    }

    private void makeSomeCommonCalculationsForAllRequests(HttpServletRequest request) {

    }

    private void processDynamicResource(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException  {
        String command = "";
        if (request.getParameter("command") != null) {
            command = request.getParameter("command");
        }
        switch(command) {
            case "viewPage1" : {
                prepareDataForPage1(request, response );
                break;
            }
            case "viewPage2" : {
                prepareDataForPage3(request, response);
                break;
            }
            case "viewWelcome" : {
                prepareDataForWelcomePage(request, response );
                break;
            }
            default : {
                prepareDataForWelcomePage(request, response );
                break;
            }
        }
    }

    private void prepareDataForWelcomePage(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException  {
        fetchPageDataFromDatabase(request, response);
        performSomeAdditionalProcessing(request, response);
        request.setAttribute("title", "Front Controller ");
        request.setAttribute("data", new PageData("Список фильтров этого примера", " 1 - Фильтр, устанавливающий кодировку для RQ/RS. 2 - Фильтр, осуществляюший логгирование RQ/RS. 3- Перенаправление на другие URL\n"));
        request.getRequestDispatcher("/WEB-INF/welcome.jsp").forward(request, response);
    }

    private void prepareDataForPage1(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException  {
        fetchPageDataFromDatabase(request, response);
        performSomeAdditionalProcessing(request, response);
        request.setAttribute("title", "Front Controller - Страница 1");
        request.setAttribute("data", new PageData("Представление 1", "Страница, требующая подготовки большого числа данных"));
        request.getRequestDispatcher("/WEB-INF/page1.jsp").forward(request, response);
    }

    private void prepareDataForPage3(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException  {
        fetchPageDataFromDatabase(request, response);
        performSomeAdditionalProcessing(request, response);
        request.setAttribute("title", "Front Controller  - Страница 3");
        request.setAttribute("data", new PageData("Redirect со старых адресов на новые", "Зачастую необходимо, чтобы устаревшие адреса все равно возвращали контент. Это можно реализовать посредством фильтра. Сервлет, возвративший эту страницу, замаплен на path, отличный от того, что можно видеть в браузере. Фильтр перенаправляет запрос со старого URL на новый."));
        request.getRequestDispatcher("/WEB-INF/page3.jsp").forward(request, response);
    }

    private void fetchPageDataFromDatabase(HttpServletRequest request, HttpServletResponse response) {
        //Different queries to databases or web services here
    }

    private void performSomeAdditionalProcessing(HttpServletRequest request, HttpServletResponse response) {
        //Page business logic here
    }
}
