package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CounterTable implements TableDB
{
    public static void bildCounterTable(){
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(DB_URL + db, USER, PASS);
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS counter " +
                    "(id SERIAL PRIMARY KEY, date_time timestamp, numb text, " +
                    "original text, mistakes text, part VARCHAR(12));");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
