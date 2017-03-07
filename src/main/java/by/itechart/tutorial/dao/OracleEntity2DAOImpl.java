package by.itechart.tutorial.dao;

import by.itechart.tutorial.model.DbEntity2;

public class OracleEntity2DAOImpl implements Entity2DAO {

    @Override
    public void save(DbEntity2 entity) {
        //Save DB record using specific Oracle API
    }

    @Override
    public void update(DbEntity2 entity) {
        //Update DB record  using specific Oracle API
    }

    @Override
    public void delete(DbEntity2 entity) {
        //Delete DB record  using specific Oracle API
    }

    @Override
    public DbEntity2 findBySomeCriteria() {
        // Find entity by criteria using specific Oracle API
        return new DbEntity2(100, " Message");
    }
}
