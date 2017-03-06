package by.itechart.tutorial.services;

import by.itechart.tutorial.model.PageData;
import by.itechart.tutorial.model.PageSpecification;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by alexander.belyaev on 3/3/2017.
 */
public class WelcomePageViewHelper  implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        System.out.println("=========WELCOME HELPER ===========");
        fetchPageDataFromDatabase(request, response);
        performSomeAdditionalProcessing(request, response);
        request.setAttribute("title", "Composite View");
        request.setAttribute("data", new PageData("Составное представление, реализованное с помощью стандартного тега",
                "Composite View позволяет избавиться от повторного использования частей View типа 'copy-paste'" +
                 "В данном случае header, footer и общий шаблон страницы  был общий для всех представлений приложения и были вынесены в отдельные sub-view."
              ));
        request.setAttribute("page", new PageSpecification("/WEB-INF/common/footer.jsp", "/WEB-INF/common/header.jsp", "/WEB-INF/contents/welcome.jsp"));
        request.getRequestDispatcher("/WEB-INF/common/layout.jsp").forward(request, response);
    }

    private void fetchPageDataFromDatabase(HttpServletRequest request, HttpServletResponse response) {
        //Different queries to databases or web services here
    }

    private void performSomeAdditionalProcessing(HttpServletRequest request, HttpServletResponse response) {
        //Page business logic here
    }
}
