package texts;

import db.TableDB;
import interfaceRoot.ArgumentsTexts;

import java.sql.*;

class EventsColorMenuTexts implements ArgumentsTexts, TableDB
{
    void getEvents(){
        yellow.setOnAction(event -> colorDB("yellow"));
        red.setOnAction(event -> colorDB("red"));
        green.setOnAction(event -> colorDB("green"));
        blue.setOnAction(event -> colorDB("blue"));
        purple.setOnAction(event -> colorDB("purple"));
        black.setOnAction(event -> colorDB("black"));
    }
    private void colorDB(String s){
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(DB_URL + db, USER, PASS);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id FROM my_text WHERE title_text = '"+listName.getValue()+"';");
            int a = 0;
            while (resultSet.next()){
                a = resultSet.getInt("id");
            }
            statement.executeUpdate("UPDATE my_text SET color = '"+ s +"' WHERE id = "
                    + a +";");
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
