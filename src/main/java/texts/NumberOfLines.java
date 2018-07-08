package texts;

import db.CreateDB;
import db.TableDB;

import java.sql.*;

public class NumberOfLines implements TableDB
{
    // Кол-во строк таблицы:
    int numberOfLines(){

        int lines = 0;
        Statement statement;
        Connection connection;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(DB_URL + db, USER, PASS);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT count(*) FROM my_text;");
            resultSet.next();
            lines = resultSet.getInt("count");
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return lines;
    }
}
