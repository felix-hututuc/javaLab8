package db;

import java.sql.*;

public class ContinentDAO {
    public void create(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement preparedStatement = con.prepareStatement(
                "insert into continents (name) values (?)"
        )) {
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
        }
    }

    public Integer findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement statement = con.createStatement();
             ResultSet rs = statement.executeQuery(
                     "select id from continents where name='" + name + "'"
             )
        ) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }

    public String findById(Integer continentId) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement statement = con.createStatement();
             ResultSet rs = statement.executeQuery(
                     "select name from continents where id='" + continentId + "'"
             )
        ) {
            return rs.next() ? rs.getString(1) : null;
        }
    }
}
