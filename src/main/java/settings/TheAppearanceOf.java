package settings;

import interfaceRoot.ArgumentsSettings;
import javafx.geometry.Pos;

class TheAppearanceOf implements ArgumentsSettings
{

    void changeColor(){
//        color.setStyle("-fx-background-color: #ffffff;");
        color.getStyleClass().add("colorMenuSettings");
//        color.setOnMouseEntered(event -> color.setStyle("-fx-background-color: #999999;")); //действие при наведение курсора
//        color.setOnMouseExited(event -> color.setStyle("-fx-background-color: #ffffff;")); //действие при отведении курсора
        color.setPrefWidth(widthSize/5.5);
        color.setAlignment(Pos.CENTER_LEFT);
        color.setOnAction(event -> {
            CleaningSettings.clear();
            addColorMenu();
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

        examColorOneL.setOnAction(event -> {
            // TODO сделать метод обновляющий цвета в базе
            try {
                String hex1 = Integer.toHexString(examColorOneL.getValue().hashCode()).substring(0, 6).toUpperCase();
                System.out.println(hex1);
            } catch (Exception e){
                System.out.println("black");
            }
        });

        ROOT.getChildren().add(settingColor);
        one.getChildren().addAll(examColorOneL, examColorOne);
        two.getChildren().addAll(examColorTwoL, examColorTwo);
        three.getChildren().addAll(exerciseColorOneL, exerciseColorOne);
        four.getChildren().addAll(exerciseColorTwoL, exerciseColorTwo);
        five.getChildren().addAll(counterColorL, counterColor);
        six.getChildren().addAll(sectionColorL, sectionColor);
        seven.getChildren().addAll(sceneColorL, sceneColor);
        eight.getChildren().addAll(timeColorL, timeColor);
        settingColor.getChildren().addAll(one, two, three, four, five, six, seven, eight);
        settingColor.setLayoutX(widthSize/2.3);
        settingColor.setLayoutY(heightSize/8);
    }
}
