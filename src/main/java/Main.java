import db.ContinentDAO;
import db.CountryDAO;
import db.Database;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        try {
            var continents = new ContinentDAO();
            continents.create("Europe");
            Database.getConnection().commit();

            var countries = new CountryDAO();
            int europeId = continents.findByName("Europe");
            countries.create("Romania", europeId);
            countries.create("Ukraine", europeId);
            Database.getConnection().commit();

            Database.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                Database.getConnection().rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
