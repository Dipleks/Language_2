package interfaceRoot;

import control.MenuBarEngRus;
import db.TableDB;
import settings.ColorSetting;
import update.UpDate;
import update.WindowUpdate_2_2_0;

import java.sql.*;

public class Run implements Root, TableDB
{
    private MenuBarEngRus menuBarEngRus = new MenuBarEngRus();
    private static ColorSetting colorSetting = new ColorSetting();
    private WindowUpdate_2_2_0 version_2_2_0 = new WindowUpdate_2_2_0();
    private UpDate upDate = new UpDate();

    public void runMethod() {

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

        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(DB_URL + db, USER, PASS);
            Statement statement = connection.createStatement();
            ResultSet r = statement.executeQuery("SELECT actions FROM settings WHERE id = 11;");
            r.next();
            if (r.getString("actions").equals("not_done")){

                version_2_2_0.startUpDate(upDate);

            } else {
                System.out.println("обновление выполнено!");
            }
            r.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("exception");
            version_2_2_0.startUpDate(upDate);
            e.printStackTrace();
        }
        WINDOW.show();

    }
}
