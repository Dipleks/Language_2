package texts;

import db.CreateDB;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NumberOfLines
{
    // Кол-во строк таблицы:
    public static int numberOfLines(){
        ResultSet resultSet = null;
        int lines = 0;
        try {
            resultSet = CreateDB.connection().executeQuery("SELECT count(*) FROM my_text;");
            resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            assert resultSet != null;
            lines = resultSet.getInt("count");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lines;
    }
}
