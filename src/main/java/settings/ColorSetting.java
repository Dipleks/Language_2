package settings;

import db.TableDB;
import interfaceRoot.ArgumentsSettings;
import javafx.scene.paint.Color;

import java.sql.*;

public class ColorSetting implements ArgumentsSettings, TableDB
{
    public void getColorExamAndExercise(){
        Color color = null;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(DB_URL + db, USER, PASS);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM settings WHERE id = 1;");
            resultSet.next();
            String colorStr = resultSet.getString("actions");
            color = Color.rgb(Integer.valueOf( colorStr.substring( 0, 2 ), 16 ),
                    Integer.valueOf( colorStr.substring( 2, 4 ), 16 ),
                    Integer.valueOf( colorStr.substring( 4, 6 ), 16 ));
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        examColorOneL.setValue(color);
    }
    public void getColorExamNumber(){
        Color color = null;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(DB_URL + db, USER, PASS);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM settings WHERE id = 2;");
            resultSet.next();
            String colorStr = resultSet.getString("actions");
            color = Color.rgb(Integer.valueOf( colorStr.substring( 0, 2 ), 16 ),
                    Integer.valueOf( colorStr.substring( 2, 4 ), 16 ),
                    Integer.valueOf( colorStr.substring( 4, 6 ), 16 ));
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        examColorTwoL.setValue(color);
    }
    public void getColorTranslation(){
        Color color = null;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(DB_URL + db, USER, PASS);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM settings WHERE id = 3;");
            resultSet.next();
            String colorStr = resultSet.getString("actions");
            color = Color.rgb(Integer.valueOf( colorStr.substring( 0, 2 ), 16 ),
                    Integer.valueOf( colorStr.substring( 2, 4 ), 16 ),
                    Integer.valueOf( colorStr.substring( 4, 6 ), 16 ));
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        exerciseColorOneL.setValue(color);
    }
    public void getColorMistakesExam(){
        Color color = null;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(DB_URL + db, USER, PASS);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM settings WHERE id = 4;");
            resultSet.next();
            String colorStr = resultSet.getString("actions");
            color = Color.rgb(Integer.valueOf( colorStr.substring( 0, 2 ), 16 ),
                    Integer.valueOf( colorStr.substring( 2, 4 ), 16 ),
                    Integer.valueOf( colorStr.substring( 4, 6 ), 16 ));
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        exerciseColorTwoL.setValue(color);
    }
    public void getColorCounterExam(){
        Color color = null;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(DB_URL + db, USER, PASS);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM settings WHERE id = 5;");
            resultSet.next();
            String colorStr = resultSet.getString("actions");
            color = Color.rgb(Integer.valueOf( colorStr.substring( 0, 2 ), 16 ),
                    Integer.valueOf( colorStr.substring( 2, 4 ), 16 ),
                    Integer.valueOf( colorStr.substring( 4, 6 ), 16 ));
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        counterColorL.setValue(color);
    }
    public void getColorSection(){
        Color color = null;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(DB_URL + db, USER, PASS);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM settings WHERE id = 6;");
            resultSet.next();
            String colorStr = resultSet.getString("actions");
            color = Color.rgb(Integer.valueOf( colorStr.substring( 0, 2 ), 16 ),
                    Integer.valueOf( colorStr.substring( 2, 4 ), 16 ),
                    Integer.valueOf( colorStr.substring( 4, 6 ), 16 ));
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        sectionColorL.setValue(color);
    }
    public void getColorScene(){
        Color color = null;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(DB_URL + db, USER, PASS);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM settings WHERE id = 7;");
            resultSet.next();
            String colorStr = resultSet.getString("actions");
            color = Color.rgb(Integer.valueOf( colorStr.substring( 0, 2 ), 16 ),
                    Integer.valueOf( colorStr.substring( 2, 4 ), 16 ),
                    Integer.valueOf( colorStr.substring( 4, 6 ), 16 ));
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        sceneColorL.setValue(color);
    }
    public void getColorTime(){
        Color color = null;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(DB_URL + db, USER, PASS);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM settings WHERE id = 8;");
            resultSet.next();
            String colorStr = resultSet.getString("actions");
            color = Color.rgb(Integer.valueOf( colorStr.substring( 0, 2 ), 16 ),
                    Integer.valueOf( colorStr.substring( 2, 4 ), 16 ),
                    Integer.valueOf( colorStr.substring( 4, 6 ), 16 ));
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        timeColorL.setValue(color);
    }
    public void getColorButton(){
        Color color = null;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(DB_URL + db, USER, PASS);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM settings WHERE id = 9;");
            resultSet.next();
            String colorStr = resultSet.getString("actions");
            color = Color.rgb(Integer.valueOf( colorStr.substring( 0, 2 ), 16 ),
                    Integer.valueOf( colorStr.substring( 2, 4 ), 16 ),
                    Integer.valueOf( colorStr.substring( 4, 6 ), 16 ));
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        buttonColorL.setValue(color);
    }
    public void getColorIllumination(){
        Color color = null;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(DB_URL + db, USER, PASS);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM settings WHERE id = 10;");
            resultSet.next();
            String colorStr = resultSet.getString("actions");
            color = Color.rgb(Integer.valueOf( colorStr.substring( 0, 2 ), 16 ),
                    Integer.valueOf( colorStr.substring( 2, 4 ), 16 ),
                    Integer.valueOf( colorStr.substring( 4, 6 ), 16 ));
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        buttonIlluminationL.setValue(color);
    }
}
