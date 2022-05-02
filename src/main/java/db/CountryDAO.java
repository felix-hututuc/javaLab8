package db;

import java.sql.*;

public class CountryDAO {
    public void create(String name, Integer continentId) throws SQLException {
        Connection con = Database.getConnection();
        String continentName;
        try (Statement statement = con.createStatement();
             ResultSet rs = statement.executeQuery(
                     "select name from continents where id='" + continentId + "'"
             )
        ) {
            if (rs.next()) {
                continentName = rs.getString(1);
            } else {
                System.out.println("Invalid continent");
                return;
            }
        }
        try (PreparedStatement preparedStatement = con.prepareStatement(
                "insert into countries (name, continent) values (?, ?)"
        )) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, continentName);
            preparedStatement.executeUpdate();
        }
    }

    public Integer findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement statement = con.createStatement();
             ResultSet rs = statement.executeQuery(
                     "select id from countries where name='" + name + "'"
             )
        ) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }

    public String findById(Integer continentId) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement statement = con.createStatement();
             ResultSet rs = statement.executeQuery(
                     "select name from countries where id='" + continentId + "'"
             )
        ) {
            return rs.next() ? rs.getString(1) : null;
        }
    }
}
