package settings;

import control.ClearDisplay;
import control.MenuBarEngRus;
import interfaceRoot.ArgumentsSettings;
import javafx.geometry.Pos;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

class TheAppearanceOf implements ArgumentsSettings
{
    private VBox settingColor = new VBox();
    private HBox one = new HBox();
    private HBox two = new HBox();
    private HBox three = new HBox();
    private HBox four = new HBox();
    private HBox five = new HBox();

    private Label examColorOne = new Label("Цвет Контрльных по умолчанию");
    private Label examColorTwo = new Label("Цвет Контрльных при переводе");
    private Label exerciseColorOne = new Label("Цвет Заданий по умолчанию");
    private Label exerciseColorTwo = new Label("Цвет Заданий при переводе");
    private Label timeColor = new Label("Цвет Часов");

    private ColorPicker examColorOneL = new ColorPicker();
    private ColorPicker examColorTwoL = new ColorPicker();
    private ColorPicker exerciseColorOneL = new ColorPicker();
    private ColorPicker exerciseColorTwoL = new ColorPicker();
    private ColorPicker timeColorL = new ColorPicker();

    void changeColor(){

        color.setStyle("-fx-background-color: #ffffff;");
        color.setOnMouseEntered(event -> color.setStyle("-fx-background-color: #12affe;")); //действие при наведение курсора
        color.setOnMouseExited(event -> color.setStyle("-fx-background-color: #ffffff;")); //действие при отведении курсора
        color.setPrefWidth(widthSize/5.5);
        color.setAlignment(Pos.CENTER_LEFT);
        color.setOnAction(event -> {
            ROOT.getChildren().remove(settingColor);
            settingColor.getChildren().clear();
            one.getChildren().clear();
            two.getChildren().clear();
            three.getChildren().clear();
            four.getChildren().clear();
            five.getChildren().clear();
            ROOT.getChildren().add(settingColor);
            addColorMenu();
        });

    }
    private void addColorMenu(){
        one.getChildren().addAll(examColorOne, examColorOneL);
        two.getChildren().addAll(examColorTwo, examColorTwoL);
        three.getChildren().addAll(exerciseColorOne, exerciseColorOneL);
        four.getChildren().addAll(exerciseColorTwo, exerciseColorTwoL);
        five.getChildren().addAll(timeColor, timeColorL);
        settingColor.getChildren().addAll(one, two, three, four, five);
    }
}
