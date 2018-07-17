import db.*;
import interfaceRoot.*;
import javafx.application.Application;
import javafx.stage.Stage;

import java.sql.*;

public class Language_2 extends Application implements Root, TableDB
{
    private Run run = new Run();
//    private ColletionText colletionText = new ColletionText();
//    private Map<Integer, String> textEnL = new HashMap<>();
//    private Map<Integer, String> textRuL = new HashMap<>();

    @Override
    public void init() throws Exception {
//        colletionText.setTextEn(textEnL);
//        colletionText.setTextRu(textRuL);
    }

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



        run.runMethod();
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
