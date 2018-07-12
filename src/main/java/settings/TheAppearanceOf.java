package settings;

import interfaceRoot.ArgumentsSettings;
import javafx.geometry.Pos;
import javafx.scene.control.Button;

class TheAppearanceOf implements ArgumentsSettings
{
    private UpdateColorTable updateColorTable = new UpdateColorTable();

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

        ROOT.getChildren().add(settingColor);
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
        settingColor.setLayoutX(widthSize/2.3);
        settingColor.setLayoutY(heightSize/8);
    }
}
