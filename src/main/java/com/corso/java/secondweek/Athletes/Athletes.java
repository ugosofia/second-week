package com.corso.java.secondweek.Athletes;

import com.corso.java.secondweek.utils.ConnectDB;
import lombok.*;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Data @Builder @AllArgsConstructor
public class Athletes {

    @Getter @Setter private int code;
    @Getter @Setter private String name;
    @Getter @Setter private String country;
    @Getter @Setter private Date birth_date;
    @Getter @Setter private double height;

    private final static String SELECT_ATHLETES = "SELECT code, name FROM athletes WHERE ? > ?";


    public List<Athletes> findTallAthletes(double h) {
        ArrayList<Athletes> list = new ArrayList<>();

        try (Connection con = ConnectDB.connect()) {
            PreparedStatement ps =
                         con.prepareStatement(SELECT_ATHLETES);

                ps.setDouble(1, height);
                ps.setDouble(2, h);

                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        list.add(
                                Athletes.builder()
                                        .code(rs.getInt("code"))
                                        .name(rs.getString("name"))
                                        .build());
                    }
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}