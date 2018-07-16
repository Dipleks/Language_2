package update;

import db.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class WindowUpdate_2_2_0 implements IUpDate
{
    @Override
    public void startUpDate(UpDate upDate) {
        upDate.getUpdate(textUpdate_2_2_0);
        update.setOnAction(event -> {
            ProgressBarUpDate.getProgressBar();
            try {
                Class.forName("org.postgresql.Driver");
                Connection connection = DriverManager.getConnection(DB_URL + db, USER, PASS);
                Statement statement = connection.createStatement();
                statement.executeUpdate("DROP TABLE counter;");
                statement.executeUpdate("DROP TABLE my_text;");
                statement.executeUpdate("DROP TABLE my_words;");
                statement.executeUpdate("DROP TABLE settings;");
                createTable();
                statement.executeUpdate("UPDATE settings SET actions = 'done' WHERE id = 11;");
                statement.close();
                connection.close();

            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("таблицы my_text не существует");
                createTable();
            }
        });

    }
    private void createTable(){
        CounterTable.bildCounterTable();
        MyTextTable.bildMyTextTable();
        MyWordsTable.bildMyWordsTable();
        SettingsTable.bildSettingsTable();
    }
}
