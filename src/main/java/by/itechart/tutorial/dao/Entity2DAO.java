package by.itechart.tutorial.dao;

import by.itechart.tutorial.model.DbEntity2;

public class Entity2DAO {
    public void save(DbEntity2 entity) {}
    public void update(DbEntity2 entity) {}
    public void delete(DbEntity2 entity) {};
    public DbEntity2 findBySomeCriteria(){
        return new DbEntity2(100, " Message");
    }
}
