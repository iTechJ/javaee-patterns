package by.itechart.tutorial.viewhelper;

import by.itechart.tutorial.viewhelper.advanced.AdvancedPage1ViewHelper;
import by.itechart.tutorial.viewhelper.advanced.AdvancedPage3ViewHelper;
import by.itechart.tutorial.viewhelper.advanced.AdvancedWelcomePageViewHelper;

import java.util.HashMap;
import java.util.Map;

public class AdvancedCommandMapper extends  CommandMapper {
    private Map<String, Class> processors = new HashMap<String, Class>();
    {
        processors.put("viewPage1", AdvancedPage1ViewHelper.class);
        processors.put("viewPage2", AdvancedPage3ViewHelper.class);
        processors.put("viewWelcome", AdvancedWelcomePageViewHelper.class);
        processors.put(null, AdvancedWelcomePageViewHelper.class);
    }

    @Override
    protected Map<String, Class> getProcessors() {
        return processors;
    }
}
