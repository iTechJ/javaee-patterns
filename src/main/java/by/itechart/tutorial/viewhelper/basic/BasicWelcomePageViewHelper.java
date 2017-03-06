package by.itechart.tutorial.viewhelper.basic;

import by.itechart.tutorial.dto.PageData;
import by.itechart.tutorial.dto.PageSpecification;
import by.itechart.tutorial.viewhelper.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by alexander.belyaev on 3/3/2017.
 */
public class BasicWelcomePageViewHelper implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        request.setAttribute("title", "Data Access Object");
        request.setAttribute("data", new PageData("Data Access Object", "Обращение к базам данных и сторонним ресурсам должно быть инкапсулировано в DAO"));
        request.setAttribute("page", new PageSpecification("/WEB-INF/common/footer.jsp", "/WEB-INF/common/header.jsp", "/WEB-INF/contents/basic/welcome.jsp"));
        request.getRequestDispatcher("/WEB-INF/common/layout.jsp").forward(request, response);
    }
}
