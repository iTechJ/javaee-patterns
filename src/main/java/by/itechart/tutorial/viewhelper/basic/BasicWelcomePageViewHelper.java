package by.itechart.tutorial.viewhelper.basic;

import by.itechart.tutorial.model.PageData;
import by.itechart.tutorial.model.PageSpecification;
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
        System.out.println("=========WELCOME HELPER ===========");
        fetchPageDataFromDatabase(request, response);
        performSomeAdditionalProcessing(request, response);
        request.setAttribute("title", "Application Controller");
        request.setAttribute("data", new PageData("Application Controller", "Позволяет добавлять view и обработку, специфическую для какого-нибудь клиента, не меняя все остальное приложение"));
        request.setAttribute("page", new PageSpecification("/WEB-INF/common/footer.jsp", "/WEB-INF/common/header.jsp", "/WEB-INF/contents/basic/welcome.jsp"));
        request.getRequestDispatcher("/WEB-INF/common/layout.jsp").forward(request, response);
    }

    private void fetchPageDataFromDatabase(HttpServletRequest request, HttpServletResponse response) {
        //Different queries to databases or web viewhelper here
    }

    private void performSomeAdditionalProcessing(HttpServletRequest request, HttpServletResponse response) {
        //Page business logic here
    }
}
