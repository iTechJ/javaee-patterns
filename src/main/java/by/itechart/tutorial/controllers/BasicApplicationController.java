package by.itechart.tutorial.controllers;

import by.itechart.tutorial.viewhelper.BasicCommandMapper;
import by.itechart.tutorial.viewhelper.CommandMapper;

/**
 * Created by alexander.belyaev on 3/6/2017.
 */
public class BasicApplicationController extends  ApplicationController {

    @Override
    public String getControllerName() {
        return "BasicApp";
    }

    @Override
    public CommandMapper getCommandMapper() {
        return new BasicCommandMapper();
    }
}
