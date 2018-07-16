package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SettingsTable implements TableDB
{
    public static void bildSettingsTable(){
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(DB_URL + db, USER, PASS);
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS settings " +
                    "(id SERIAL PRIMARY KEY, parameter VARCHAR(50), actions VARCHAR(60));");
            addSettings();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    private static void addSettings(){
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(DB_URL + db, USER, PASS);
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO settings (parameter, actions) " +
                    "VALUES ('Цвет заданий и контрольных', '1a1a1a'), " +
                    "('Цвет контрольных при нажатии на номер', '800080'), " +
                    "('Цвет при переводе', '32cd32'), " +
                    "('Цвет при неверном ответе в контрольных', 'ff0000'), " +
                    "('Цвет значений счетчика контрольных', 'cd853f'), " +
                    "('Цвет разделов заданий', 'a9a9a9'), " +
                    "('Цвет Scene', 'ffffff'), " +
                    "('Цвет часов', '006400')," +
                    "('Цвет кнопок', 'e6e6e6')," +
                    "('Цвет подсветки кнопок', '006400')," +
                    "('Обновление', 'not_done');");
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
