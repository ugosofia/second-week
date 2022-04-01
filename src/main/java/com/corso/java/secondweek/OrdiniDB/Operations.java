package com.corso.java.secondweek.OrdiniDB;

import java.sql.SQLException;
import java.util.List;

public interface Operations<K> {

    //public void createDB();
    public void createTable();
    public boolean insert();
    public boolean delete(K object);
    public List<K> findbyprimarykey(int id) ;
    public List<K> findbyforeignkey(int id) ;


}
