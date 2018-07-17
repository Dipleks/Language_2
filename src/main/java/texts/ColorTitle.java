package texts;

import db.TableDB;
import interfaceRoot.ArgumentsTexts;
import interfaceRoot.EffectColor;
import java.sql.*;

class ColorTitle implements ArgumentsTexts, TableDB
{
    // Получаем цвет заголока:
    void getColorTitle(){
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(DB_URL + db, USER, PASS);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT color FROM my_text " +
                    "WHERE title_text = '"+ TITLE.getText() +"' ORDER BY id;");
            while (resultSet.next()){
                switch (resultSet.getString("color")) {
                    case "yellow":
                        TITLE.setTextFill(EffectColor.getColorYellow());
                        break;
                    case "red":
                        TITLE.setTextFill(EffectColor.getColorRed());
                        break;
                    case "green":
                        TITLE.setTextFill(EffectColor.getColorGreen());
                        break;
                    case "blue":
                        TITLE.setTextFill(EffectColor.getColorBlue());
                        break;
                    case "purple":
                        TITLE.setTextFill(EffectColor.getColorPurple());
                        break;
                    case "black":
                        TITLE.setTextFill(EffectColor.getColorBlack());
                        break;
                }
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
