package com.corso.java.secondweek.secondo;

import java.sql.SQLException;

public interface db<K> {

    void readDatabase() throws SQLException;

    void close() throws SQLException;
    //void writeResult(K result);
}
