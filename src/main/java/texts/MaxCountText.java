package texts;

import db.CreateDB;
import db.TableDB;

import java.sql.*;

class MaxCountText implements TableDB
{
    // Получаем кол-во текстов
    static int getCountTable(){

        Statement statement;
        Connection connection;
        int count = 0;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(DB_URL + db, USER, PASS);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT count(id) FROM my_text;");
            resultSet.next();
            count = resultSet.getInt("count");
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return count;
    }
}
