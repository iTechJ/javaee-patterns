package by.itechart.tutorial.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
    The meaning of Session Facade has changed a lot.
    There are no more remove access to business logic objects
    Now it's more about providing View helpers/Command with high-level API for business operations.
    To perform some processing, ViewHelper or Command should call BusinessService.performSomeAction() which encapsulated details of processing.
    It's a bad practise to call BusinessService.step1(); BusinessService.step2(); BusinessService.stepN(); directly.
 */
public class BusinessService2 {
    public void performSomeAction(HttpServletRequest request, HttpServletResponse response) {
        step1();
        step2();
        //...
        stepN();
    }
    private void step1() {

    }

    private void step2() {

    }

    //...
    private void stepN() {

    }
}
