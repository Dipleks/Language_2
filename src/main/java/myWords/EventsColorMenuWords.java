package myWords;

import db.TableDB;
import interfaceRoot.ArgumentsMyWords;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EventsColorMenuWords implements ArgumentsMyWords, TableDB
{
    void getEvents(int n){
        KNOW_ON_ONE.setOnAction(event -> colorDB("Знаю на 1", n));
        KNOW_ON_TWO.setOnAction(event -> colorDB("Знаю на 2", n));
        KNOW_ON_THREE.setOnAction(event -> colorDB("Знаю на 3", n));
        KNOW_ON_FOUR.setOnAction(event -> colorDB("Знаю на 4", n));
        KNOW_ON_FIVE.setOnAction(event -> colorDB("Знаю на 5", n));
    }
    private void colorDB(String s, int n){
        Statement statement;
        Connection connection;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(DB_URL + db, USER, PASS);
            statement = connection.createStatement();
            statement.executeUpdate("UPDATE my_words SET color = '"+ s +"' WHERE id = "
                    + n +"+1;");
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
