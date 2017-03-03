package by.itechart.tutorial.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by alexander.belyaev on 3/3/2017.
 */
public class Commands {
    private static  Map<String, Class> processors = new HashMap<String, Class>();
    static {
        processors.put("viewPage1", Page1ViewHelper.class);
        processors.put("viewPage2", Page3ViewHelper.class);
        processors.put("viewWelcome", WelcomePageViewHelper.class);
        processors.put(null, WelcomePageViewHelper.class);
    }

    public static Command getRequestProcessor(String command) {
        Class processorClass = processors.get(command);
        if(processorClass != null) {
            try {
                return (Command)processorClass.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
