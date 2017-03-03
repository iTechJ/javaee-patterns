package by.itechart.tutorial.controllers;

import by.itechart.tutorial.model.PageData;
import by.itechart.tutorial.services.Command;
import by.itechart.tutorial.services.Commands;
import by.itechart.tutorial.services.StaticResourcesHelper;
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
       new StaticResourcesHelper().execute(request, response);
    }

    //It's not very accurate function actually... just to exemplify the case
    private boolean isStaticResource(String requestedURI) {
        return requestedURI != null && (requestedURI.endsWith(".css") || requestedURI.endsWith(".js"));
    }

    private void makeSomeCommonCalculationsForAllRequests(HttpServletRequest request) {

    }

    private void processDynamicResource(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException  {
        Command command = Commands.getRequestProcessor(request.getParameter("command"));
        if(command != null) {
            command.execute(request, response);
        }
    }
}
