package com.corso.java.secondweek.Athletes;

import java.sql.SQLException;
import java.util.List;

public interface BaseRepository<K> {

        public boolean persist(K athlete);
        public boolean delete(K athlete);
        public List<K> findbyprimarykey(K code) throws SQLException;
        public void findAll();
        public void close();
        }
