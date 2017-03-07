package by.itechart.tutorial.dao;

import by.itechart.tutorial.model.DbEntity1;


public class Entity1DAOImpl implements Entity1DAO{
    @Override
    public void save(DbEntity1 entity) {
        //Save DB record
    }
    @Override
    public void update(DbEntity1 entity) {
        //Update DB record
    }
    @Override
    public void delete(DbEntity1 entity) {
        //Delete DB record
    };
    @Override
    public DbEntity1 findBySomeCriteria(){
        return  new DbEntity1(System.currentTimeMillis());
    }
}
