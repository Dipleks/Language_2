import control.MenuBarEngRus;
import db.*;
import interfaceRoot.*;
import javafx.application.Application;
import javafx.stage.Stage;
import settings.ColorSetting;
import update.WindowUpdate;

import java.sql.*;

public class Language_2 extends Application implements Root, TableDB
{
    private MenuBarEngRus menuBarEngRus = new MenuBarEngRus();
    private static ColorSetting colorSetting = new ColorSetting();
    private WindowUpdate windowUpdate = new WindowUpdate();

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
//            colorSetting.getColorExamAndExercise();
//            colorSetting.getColorExamNumber();
//            colorSetting.getColorTranslation();
//            colorSetting.getColorMistakesExam();
//            colorSetting.getColorCounterExam();
//            colorSetting.getColorSection();
//            colorSetting.getColorScene();
//            colorSetting.getColorTime();
        }

        runMethod();
        windowUpdate.getUpdate();
//        try {
//            if (CreateDB.checkConnection()) {
//                runMethod();
//            } else {
//                // TODO если БД отсутствует создать вместе с ней и все таблицы!!!
//                CreateDB.newDB();
//                CreateDB.newCounterFirstRun();
//                runMethod();
//            }
//        } catch (Exception e) {
//
//            // TODO действие если БД нет вообще на ПК
//
//            System.out.println("База данных не найдена!");
//            e.printStackTrace();
//        }

    }

    public static void main(String[] args) {
        launch(args);
    }

    private void runMethod() {
        colorSetting.getColorExamAndExercise();
        colorSetting.getColorExamNumber();
        colorSetting.getColorTranslation();
        colorSetting.getColorMistakesExam();
        colorSetting.getColorCounterExam();
        colorSetting.getColorSection();
        colorSetting.getColorScene();
        colorSetting.getColorTime();
        colorSetting.getColorButton();
        colorSetting.getColorIllumination();

        menuBarEngRus.getMenu();
        ClockDisplay.clock();

        ROOT.getChildren().addAll();

        WINDOW.setTitle("language_2");
        WINDOW.setMaximized(true); //устанавливаем размер окна на весь экран
        WINDOW.setScene(SCENE_ROOT);
        WINDOW.show();
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
