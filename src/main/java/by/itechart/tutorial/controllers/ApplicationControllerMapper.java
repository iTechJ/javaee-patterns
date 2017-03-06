package by.itechart.tutorial.controllers;

import java.util.HashMap;
import java.util.Map;

/*
Now you can simply create another version of ApplicationController in order to support some specific appearance or behaviour of application.
No need to change existing code
 */
public class ApplicationControllerMapper {
    private static Map<String, Class> processors = new HashMap<String, Class>();
    static {
        processors.put(null, BasicApplicationController.class);
        processors.put("basic", BasicApplicationController.class);
        processors.put("advanced", AdvancedApplicationController.class);
    }

    public static ApplicationController getRequestProcessor(String application) {
        Class processorClass = processors.get(application);
        if(processorClass != null) {
            try {
                return (ApplicationController) processorClass.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
