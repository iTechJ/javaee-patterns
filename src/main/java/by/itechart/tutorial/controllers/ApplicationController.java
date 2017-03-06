package by.itechart.tutorial.controllers;

import by.itechart.tutorial.viewhelper.AdvancedCommandMapper;
import by.itechart.tutorial.viewhelper.Command;
import by.itechart.tutorial.viewhelper.CommandMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class ApplicationController {

   public abstract CommandMapper getCommandMapper();

   public abstract String getControllerName();
   public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      Command command = getCommandMapper().getRequestProcessor(request.getParameter("command"));
      if(command != null) {
         command.execute(request, response);
      }
   }
}
