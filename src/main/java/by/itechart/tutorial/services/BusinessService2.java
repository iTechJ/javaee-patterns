package by.itechart.tutorial.services;

import by.itechart.tutorial.dao.Entity2DAO;
import by.itechart.tutorial.dao.MongoEntity2DAOImpl;
import by.itechart.tutorial.dao.OracleEntity2DAOImpl;
import by.itechart.tutorial.dto.Service2Params;
import by.itechart.tutorial.dto.Service2Result;
import by.itechart.tutorial.model.DbEntity2;

/*
  Business logic layout really shouldn't know anything about HttpServletRequest and HttpServletResponse.
  They perform operations over POJOs
 */
public class BusinessService2 {

    //Usually it's done by dependency injection
    private Entity2DAO dao = new MongoEntity2DAOImpl();

    /*
      Because both implementations of Entity2DAO have the same API,
      you can switch from MongoEntity2DAOImpl to OracleEntity2DAOImpl by simply using another implementation of Entity2DAO
    */
 //   private Entity2DAO dao = new OracleEntity2DAOImpl();

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
        DbEntity2 dbRecord = dao.findBySomeCriteria();
        Service2Result result = new Service2Result(dbRecord.getDuration(), dbRecord.getMessage());
        return result;
    }
}
