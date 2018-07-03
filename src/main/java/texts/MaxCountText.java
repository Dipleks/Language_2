package texts;

import db.CreateDB;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MaxCountText
{
    // Получаем кол-во текстов
    public static int getCountTable(){
        ResultSet resultSet;
        int count = 0;
        try {
            resultSet = CreateDB.connection().executeQuery("SELECT count(id) FROM my_text;");
            resultSet.next();
            count = resultSet.getInt("count");
            resultSet.close();
            CreateDB.connection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}
