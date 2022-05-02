package db;

import java.sql.*;

public class CityDAO {
    public void create(String name, Integer countryId) throws SQLException {
        Connection con = Database.getConnection();
        String countryName;
        try (Statement statement = con.createStatement();
             ResultSet rs = statement.executeQuery(
                     "select name from countries where id='" + countryId + "'"
             )
        ) {
            if (rs.next()) {
                countryName = rs.getString(1);
            } else {
                System.out.println("Invalid continent");
                return;
            }
        }
        try (PreparedStatement preparedStatement = con.prepareStatement(
                "insert into cities (name, country) values (?, ?)"
        )) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, countryName);
            preparedStatement.executeUpdate();
        }
    }
}
