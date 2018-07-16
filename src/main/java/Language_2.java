import db.*;
import interfaceRoot.*;
import javafx.application.Application;
import javafx.stage.Stage;
import update.UpDate;
import update.WindowUpdate_2_2_0;

import java.sql.*;

public class Language_2 extends Application implements Root, TableDB
{
    private Run run = new Run();
    private WindowUpdate_2_2_0 version_2_2_0 = new WindowUpdate_2_2_0();

    @Override
    public void start(Stage primaryStage) {

        // TODO сделать окно загрузки создания базы данных (прогресс бар)

        if (!checkCounterTable()){
            CounterTable.bildCounterTable();
        }
        if (!checkMyTextTable()){
            MyTextTable.bildMyTextTable();
        }
        if (!checkMyWordsTable()){
            MyWordsTable.bildMyWordsTable();
        }
        if (!checkSettingsTable()){
            SettingsTable.bildSettingsTable();
        }


        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(DB_URL + db, USER, PASS);
            Statement statement = connection.createStatement();
            ResultSet r = statement.executeQuery("SELECT actions FROM settings WHERE id = 11;");
            r.next();
            if (r.getString("actions").equals("not_done")){
                UpDate upDate = new UpDate();
                version_2_2_0.startUpDate(upDate);
            } else {
                run.runMethod();
                System.out.println("обновление выполнено!");
            }
            r.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("exception");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    private boolean checkCounterTable(){
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(DB_URL + db, USER, PASS);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT table_name FROM information_schema.tables  " +
                    "WHERE table_name = 'counter' ORDER BY table_name;");
            resultSet.next();
            resultSet.getString("table_name");
            resultSet.close();
            statement.close();
            connection.close();
            return true;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Таблица counter отсутствует!");
        }
        return false;
    }
    private boolean checkMyTextTable(){
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(DB_URL + db, USER, PASS);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT table_name FROM information_schema.tables  " +
                    "WHERE table_name = 'my_text' ORDER BY table_name;");
            resultSet.next();
            resultSet.getString("table_name");
            resultSet.close();
            statement.close();
            connection.close();
            return true;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Таблица my_text отсутствует!");
        }
        return false;
    }
    private boolean checkMyWordsTable(){
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(DB_URL + db, USER, PASS);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT table_name FROM information_schema.tables  " +
                    "WHERE table_name = 'my_words' ORDER BY table_name;");
            resultSet.next();
            resultSet.getString("table_name");
            resultSet.close();
            statement.close();
            connection.close();
            return true;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Таблица my_words отсутствует!");
        }
        return false;
    }
    private boolean checkSettingsTable(){
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(DB_URL + db, USER, PASS);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT table_name FROM information_schema.tables  " +
                    "WHERE table_name = 'settings' ORDER BY table_name;");
            resultSet.next();
            resultSet.getString("table_name");
            resultSet.close();
            statement.close();
            connection.close();
            return true;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Таблица settings отсутствует!");
        }
        return false;
    }
}
