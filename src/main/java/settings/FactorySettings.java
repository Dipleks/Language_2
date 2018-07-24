package settings;

import db.*;
import interfaceRoot.ArgumentsSettings;
import interfaceRoot.EffectShadow;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class FactorySettings implements ArgumentsSettings, TableDB
{
    private ProgressBar progressBar = new ProgressBar(0);
    private static Timeline timeline;

    Button resetSettings(){
        panelSetting.setSpacing(30);
        panelSetting.setPadding(new Insets(20, 20, 20, 20));
        panelSetting.setAlignment(Pos.TOP_LEFT);

        String colorStr = Integer.toHexString(sceneColorL.getValue().hashCode()).substring(0, 6).toUpperCase();
        reset.setStyle("-fx-background-color: #"+ colorStr +";");
        reset.setOnMouseEntered(event -> reset.setStyle("-fx-background-color: #999999;")); //действие при наведение курсора
        reset.setOnMouseExited(event -> reset.setStyle("-fx-background-color: #"+ colorStr +";")); //действие при отведении курсора
        reset.setPrefWidth(widthSize/5.5);
        reset.setAlignment(Pos.CENTER_LEFT);
        reset.setOnAction(event -> {
            CleaningSettings.clear();
            deleteSettings();
        });
        return reset;
    }
    private void deleteSettings(){
        ROOT.getChildren().add(panelSetting);
        textWarning.setEffect(EffectShadow.getShadow());
        panelSetting.getChildren().addAll(textWarning, resetSettings);
        panelSetting.setLayoutX(widthSize/2.3);
        panelSetting.setLayoutY(heightSize/3);

        resetSettings.setEffect(EffectShadow.getShadow());
        resetSettings.setOnAction(event -> {
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
                progressBar.setStyle("-fx-accent: #8d5ab5;"); // цвет бара
                progressBar.setEffect(EffectShadow.getShadow());

                // создаем анимацию прогресс бара:
                timeline = new Timeline(
                        new KeyFrame(Duration.millis(0),    new KeyValue(progressBar.progressProperty(), 0)),
                        new KeyFrame(Duration.millis(7000), new KeyValue(progressBar.progressProperty(), 1))
                );
                timeline.playFromStart();

                StackPane stackPane = new StackPane();
                timeline.setOnFinished(event1 -> stackPane.getChildren().clear()); // действие после завершения работы прогресс бара

                stackPane.getChildren().add(progressBar);
                stackPane.setLayoutX(widthSize/2.3);
                stackPane.setLayoutY(heightSize/3.5);
                ROOT.getChildren().add(stackPane);
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
