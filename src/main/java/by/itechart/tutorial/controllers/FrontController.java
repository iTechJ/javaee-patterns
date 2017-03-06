package by.itechart.tutorial.controllers;

import by.itechart.tutorial.viewhelper.StaticResourcesHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
  With Application Controller, responsibility of FrontController is to decide which Application Controller should process the request
  View Helper selected moved to Application Controller logic
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
        String app = request.getParameter("application");
        ApplicationController controller = ApplicationControllerMapper.getRequestProcessor(app);
        if (controller != null) {
            System.out.println("Request for " + app + " be served by" + controller.getControllerName() + "controller");
            controller.processRequest(request, response);
        } else {
            System.out.println("Command Handler not found!");
        }
    }
}
