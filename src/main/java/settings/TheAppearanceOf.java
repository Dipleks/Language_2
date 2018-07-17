package settings;

import db.SettingsTable;
import db.TableDB;
import interfaceRoot.ArgumentsSettings;
import interfaceRoot.StyleButton;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class TheAppearanceOf implements ArgumentsSettings, TableDB
{
    private UpdateColorTable updateColorTable = new UpdateColorTable();
    private ProgressBar progressBar = new ProgressBar(0);
    private static Timeline timeline;

    void changeColor(){
        String colorStr = Integer.toHexString(sceneColorL.getValue().hashCode()).substring(0, 6).toUpperCase();
        color.setStyle("-fx-background-color: #"+ colorStr +";");
        color.setOnMouseEntered(event -> color.setStyle("-fx-background-color: #999999;")); //действие при наведение курсора
        color.setOnMouseExited(event -> color.setStyle("-fx-background-color: #"+ colorStr +";")); //действие при отведении курсора
        color.setPrefWidth(widthSize/5.5);
        color.setAlignment(Pos.CENTER_LEFT);
        color.setOnAction(event -> {
            CleaningSettings.clear();
            addColorMenu();
            resetColor();
        });
    }

    private void addColorMenu(){
        settingColor.setSpacing(15);
        one.setSpacing(15);
        two.setSpacing(15);
        three.setSpacing(15);
        four.setSpacing(15);
        five.setSpacing(15);
        six.setSpacing(15);
        seven.setSpacing(15);
        eight.setSpacing(15);
        nine.setSpacing(15);
        ten.setSpacing(15);

        String labVis = "-fx-color-label-visible: false;";
        examColorOneL.setOnAction(event -> updateColorTable.addColorExamExercise());
        examColorOneL.setStyle(labVis);
        examColorTwoL.setOnAction(event -> updateColorTable.addColorExamPressNumber());
        examColorTwoL.setStyle(labVis);
        exerciseColorOneL.setOnAction(event -> updateColorTable.addColorTranslation());
        exerciseColorOneL.setStyle(labVis);
        exerciseColorTwoL.setOnAction(event -> updateColorTable.addColorExamMistakes());
        exerciseColorTwoL.setStyle(labVis);
        counterColorL.setOnAction(event -> updateColorTable.addColorExamConter());
        counterColorL.setStyle(labVis);
        sectionColorL.setOnAction(event -> updateColorTable.addColorSectionExercise());
        sectionColorL.setStyle(labVis);
        sceneColorL.setOnAction(event -> updateColorTable.addColorScene());
        sceneColorL.setStyle(labVis);
        timeColorL.setOnAction(event -> updateColorTable.addColorTime());
        timeColorL.setStyle(labVis);
        buttonColorL.setOnAction(event -> updateColorTable.addColorButton());
        buttonColorL.setStyle(labVis);
        buttonIlluminationL.setOnAction(event -> updateColorTable.addColorIllumination());
        buttonIlluminationL.setStyle(labVis);

        ROOT.getChildren().add(scrollSettingsColor);
        one.getChildren().addAll(examColorOneL, examColorOne);
        two.getChildren().addAll(examColorTwoL, examColorTwo);
        three.getChildren().addAll(exerciseColorOneL, exerciseColorOne);
        four.getChildren().addAll(exerciseColorTwoL, exerciseColorTwo);
        five.getChildren().addAll(counterColorL, counterColor);
        six.getChildren().addAll(sectionColorL, sectionColor);
        seven.getChildren().addAll(sceneColorL, sceneColor);
        eight.getChildren().addAll(timeColorL, timeColor);
        nine.getChildren().addAll(buttonColorL, buttonColor);
        ten.getChildren().addAll(buttonIlluminationL, buttonIllumination);
        settingColor.getChildren().addAll(one, two, three, four, five, six, seven, eight, nine, ten);
        scrollSettingsColor.setContent(settingColor);
        String colorStr = Integer.toHexString(sceneColorL.getValue().hashCode()).substring(0, 6).toUpperCase();
        scrollSettingsColor.setStyle("-fx-background-color: transparent; -fx-background: #"
                + colorStr +";");
//        scrollSettingsColor.setMaxHeight(heightSize/2);
        scrollSettingsColor.setPrefSize(widthSize/3, heightSize/2);
        scrollSettingsColor.setLayoutX(widthSize/2.3);
        scrollSettingsColor.setLayoutY(heightSize/8);
    }

    private void resetColor(){

        resetColor.setLayoutX(widthSize/1.5);
        resetColor.setLayoutY(heightSize/1.5);
        resetColor.setStyle(StyleButton.getStyleButton());
        resetColor.setOnAction(event -> {
            try {
                Class.forName("org.postgresql.Driver");
                Connection connection = DriverManager.getConnection(DB_URL + db, USER, PASS);
                Statement statement = connection.createStatement();
                statement.executeUpdate("DROP TABLE settings;");
                SettingsTable.bildSettingsTable();
                statement.close();
                connection.close();

                progressBar.setPrefSize(widthSize/4, heightSize/40);
                progressBar.setStyle("-fx-accent: #8d5ab5;"); // цвет бара

                // создаем анимацию прогресс бара:
                timeline = new Timeline(
                        new KeyFrame(Duration.millis(0),    new KeyValue(progressBar.progressProperty(), 0)),
                        new KeyFrame(Duration.millis(4000), new KeyValue(progressBar.progressProperty(), 1))
                );
                timeline.playFromStart();

                StackPane stackPane = new StackPane();
                timeline.setOnFinished(event1 -> stackPane.getChildren().clear()); // действие после завершения работы прогресс бара

                VBox pull = new VBox();
                pull.setSpacing(10);
                pull.setAlignment(Pos.CENTER);
                Label label1 = new Label("Идет сброс значений... Пожалуйста подождите...");
                Label label2 = new Label("По завершении перезапустите программу!");
                pull.getChildren().addAll(label1, label2, progressBar);
                stackPane.getChildren().addAll(pull);
                stackPane.setLayoutX(widthSize/1.7);
                stackPane.setLayoutY(heightSize/1.8);
                ROOT.getChildren().add(stackPane);
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("таблицы my_text не существует");
                SettingsTable.bildSettingsTable();
            }
        });
        ROOT.getChildren().add(resetColor);
    }
}
