package by.itechart.tutorial.services;

import by.itechart.tutorial.dao.Entity2DAO;
import by.itechart.tutorial.dto.Service2Params;
import by.itechart.tutorial.dto.Service2Result;
import by.itechart.tutorial.model.DbEntity2;

/*
  Business logic layout really shouldn't know anything about HttpServletRequest and HttpServletResponse.
  They perform operations over POJOs
 */
public class BusinessService2 {
    public Service2Result performSomeAction(Service2Params params) {
        step1(params);
        step2(params);
        //...
        return fetchInformationFromDatabase(params);

    }

    private void step1(Service2Params params) {

    }

    private void step2(Service2Params params) {

    }

    //...
    private Service2Result fetchInformationFromDatabase(Service2Params params) {
        DbEntity2 dbRecord = new Entity2DAO().findBySomeCriteria();
        Service2Result result = new Service2Result(dbRecord.getDuration(), dbRecord.getMessage());
        return result;
    }
}
