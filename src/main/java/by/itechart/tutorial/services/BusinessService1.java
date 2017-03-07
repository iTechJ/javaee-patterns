package by.itechart.tutorial.services;

import by.itechart.tutorial.dao.Entity1DAO;
import by.itechart.tutorial.dao.Entity1DAOImpl;
import by.itechart.tutorial.dto.Service1Params;
import by.itechart.tutorial.dto.Service1Result;
import by.itechart.tutorial.model.DbEntity1;

/*
  Business logic layout really shouldn't know anything about HttpServletRequest and HttpServletResponse.
  They perform operations over POJOs
 */
public class BusinessService1 {

    //Usually it's done by dependency injection
    private Entity1DAO dao = new Entity1DAOImpl();

    public Service1Result performSomeAction(Service1Params params) {
        step1(params);
        step2(params);
        //...
        return fetchInformationFromDatabase(params);
    }

    private void step1(Service1Params params) {

    }

    private void step2(Service1Params params) {

    }

    //...
    private Service1Result fetchInformationFromDatabase(Service1Params params) {
        DbEntity1 dbRecord = dao.findBySomeCriteria();
        Service1Result result = new Service1Result(dbRecord.getResult());
        return result;
    }
}
