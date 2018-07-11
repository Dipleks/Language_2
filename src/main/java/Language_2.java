import control.MenuBarEngRus;
import db.CreateDB;
import db.TableDB;
import interfaceRoot.ArgumentsSettings;
import interfaceRoot.ClockDisplay;
import interfaceRoot.Root;
import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import settings.ColorSetting;

import java.sql.*;

public class Language_2 extends Application implements Root
{
    private MenuBarEngRus menuBarEngRus = new MenuBarEngRus();
    private ColorSetting colorSetting = new ColorSetting();

    @Override
    public void start(Stage primaryStage) {

        colorSetting.getColorExamAndExercise();
        colorSetting.getColorExamNumber();
        colorSetting.getColorTranslation();
        colorSetting.getColorMistakesExam();
        colorSetting.getColorCounterExam();
        colorSetting.getColorSection();
        colorSetting.getColorScene();
        colorSetting.getColorTime();

        // TODO сделать окно загрузки создания базы данных (прогресс бар)

        try {
            if (CreateDB.checkConnection()) {
                runMethod();
            } else {
                // TODO если БД отсутствует создать вместе с ней и все таблицы!!!
                CreateDB.newDB();
                CreateDB.newCounterFirstRun();
                runMethod();
            }
        } catch (Exception e) {

            // TODO действие если БД нет вообще на ПК

            System.out.println("test2");
        }

    }

    public static void main(String[] args) {
        launch(args);
    }

    private void runMethod() {
        menuBarEngRus.getMenu();
        ClockDisplay.clock();

        ROOT.getChildren().addAll();

        SCENE_ROOT.getStylesheets().add(getClass().getResource("interfaceRoot/root.css").toExternalForm());
        WINDOW.setTitle("language_2");
        WINDOW.setMaximized(true); //устанавливаем размер окна на весь экран
        WINDOW.setScene(SCENE_ROOT);
        WINDOW.show();
    }
}
