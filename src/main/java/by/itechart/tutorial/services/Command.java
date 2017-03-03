package by.itechart.tutorial.services;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by alexander.belyaev on 3/3/2017.
 */
public interface Command {
    public void execute(HttpServletRequest req, HttpServletResponse res)  throws ServletException, IOException;
}
