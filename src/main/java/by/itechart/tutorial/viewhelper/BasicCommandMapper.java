package by.itechart.tutorial.viewhelper;

import by.itechart.tutorial.viewhelper.basic.BasicPage1ViewHelper;
import by.itechart.tutorial.viewhelper.basic.BasicPage3ViewHelper;
import by.itechart.tutorial.viewhelper.basic.BasicWelcomePageViewHelper;

import java.util.HashMap;
import java.util.Map;

public class BasicCommandMapper extends  CommandMapper  {
    private  Map<String, Class> processors = new HashMap<String, Class>();
    {
        processors.put("viewPage1", BasicPage1ViewHelper.class);
        processors.put("viewPage2", BasicPage3ViewHelper.class);
        processors.put("viewWelcome", BasicWelcomePageViewHelper.class);
        processors.put(null, BasicWelcomePageViewHelper.class);
    }

    @Override
    protected Map<String, Class> getProcessors() {
        return processors;
    }
}
