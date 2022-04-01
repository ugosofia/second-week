package com.corso.java.secondweek.Athletes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public interface BaseRepository<K> {

        public boolean persist();
        public boolean delete(Athletes object) throws SQLException;
        public List findbyprimarykey(K code) throws SQLException, ClassNotFoundException;




}
