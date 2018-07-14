package texts;

import db.TableDB;
import interfaceRoot.ArgumentsTexts;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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
        Statement statement;
        Connection connection;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(DB_URL + db, USER, PASS);
            statement = connection.createStatement();
            statement.executeUpdate("UPDATE my_text SET color = '"+ s +"' WHERE id = "
                    + pagination.getCurrentPageIndex()+"+1;");
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
