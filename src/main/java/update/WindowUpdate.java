package update;

import db.*;
import interfaceRoot.ArgumentsSettings;
import interfaceRoot.Root;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class WindowUpdate implements ArgumentsSettings, TableDB
{
    private Stage stage = new Stage();
    private Group group = new Group();
    private Scene scene = new Scene(group, widthSize/2, heightSize/2);
    private Button update = new Button("Обновить");

    private ProgressBar progressBar = new ProgressBar(0);
    private static Timeline timeline;

    public void getUpdate(){
        update.setLayoutX(scene.getWidth()/1.5);
        update.setLayoutY(scene.getHeight()/1.2);

        deleteSettings();
        group.getChildren().addAll(update);

        stage.setScene(scene);
        stage.show();
    }
    private void deleteSettings(){

        update.setOnAction(event -> {
            try {
                Class.forName("org.postgresql.Driver");
                Connection connection = DriverManager.getConnection(DB_URL + db, USER, PASS);
                Statement statement = connection.createStatement();
                statement.executeUpdate("DROP TABLE counter;");
                statement.executeUpdate("DROP TABLE my_text;");
                statement.executeUpdate("DROP TABLE my_words;");
                statement.executeUpdate("DROP TABLE settings;");
                createTable();
                statement.close();
                connection.close();

                progressBar.setPrefSize(widthSize/4, heightSize/40);
                progressBar.setLayoutX(50);
                progressBar.setLayoutY(50);
                progressBar.setStyle("-fx-accent: #8d5ab5;"); // цвет бара
                group.getChildren().add(progressBar);

                // создаем анимацию прогресс бара:
                timeline = new Timeline(
                        new KeyFrame(Duration.millis(0),    new KeyValue(progressBar.progressProperty(), 0)),
                        new KeyFrame(Duration.millis(5000), new KeyValue(progressBar.progressProperty(), 1))
                );
                timeline.playFromStart();

                timeline.setOnFinished(event1 -> group.getChildren().clear()); // действие после завершения работы прогресс бара

            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("таблицы my_text не существует");
                createTable();
            }
        });
    }
    private void createTable(){
        CounterTable.bildCounterTable();
        MyTextTable.bildMyTextTable();
        MyWordsTable.bildMyWordsTable();
        SettingsTable.bildSettingsTable();
    }
}
