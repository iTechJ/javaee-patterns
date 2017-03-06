package by.itechart.tutorial.controllers;

import by.itechart.tutorial.viewhelper.AdvancedCommandMapper;
import by.itechart.tutorial.viewhelper.CommandMapper;

/**
 * Created by alexander.belyaev on 3/6/2017.
 */
public class AdvancedApplicationController extends  ApplicationController {

    @Override
    public String getControllerName() {
        return "AdvancedApp";
    }

    @Override
    public CommandMapper getCommandMapper() {
        return new AdvancedCommandMapper();
    }
}
