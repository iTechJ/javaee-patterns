package by.itechart.tutorial.dao;

import by.itechart.tutorial.model.DbEntity1;


public class Entity1DAO {
    public void save(DbEntity1 entity) {}
    public void update(DbEntity1 entity) {}
    public void delete(DbEntity1 entity) {};
    public DbEntity1 findBySomeCriteria(){
        return  new DbEntity1(System.currentTimeMillis());
    }
}