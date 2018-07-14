package interfaceRoot;

import db.TableDB;
import javafx.scene.paint.Color;

public class EffectColor implements TableDB, ArgumentsSettings
{
    public static Color getColorText() {
//        String colorStr = String.valueOf(examColorOneL.getValue());
//        Color colorText = Color.web("#" + colorStr.substring(2, 8).toUpperCase());
        String colorStr = Integer.toHexString(examColorOneL.getValue().hashCode()).substring(0, 6).toUpperCase();
        if (colorStr.equalsIgnoreCase("6400ff")){
            Color colorClock = Color.web("#006400");
            return colorClock;
        }
        Color colorText = Color.web("#" + colorStr);
        return colorText;
    }

    public static Color getColorTextImpr() {
//        String colorStr = String.valueOf(examColorTwoL.getValue());
//        Color colorTextImpr = Color.web("#" + colorStr.substring(2, 8).toUpperCase());
        String colorStr = Integer.toHexString(examColorTwoL.getValue().hashCode()).substring(0, 6).toUpperCase();
        if (colorStr.equalsIgnoreCase("6400ff")){
            Color colorClock = Color.web("#006400");
            return colorClock;
        }
        Color colorTextImpr = Color.web("#" + colorStr);
        return colorTextImpr;
    }

    public static Color getColorTextClick() {
//        String colorStr = String.valueOf(exerciseColorOneL.getValue());
//        Color colorTextClick = Color.web("#" + colorStr.substring(2, 8).toUpperCase());
        String colorStr = Integer.toHexString(exerciseColorOneL.getValue().hashCode()).substring(0, 6).toUpperCase();
        if (colorStr.equalsIgnoreCase("6400ff")){
            Color colorClock = Color.web("#006400");
            return colorClock;
        }
        Color colorTextClick = Color.web("#" + colorStr);
        return colorTextClick;
    }

    public static Color getColorTextClickRED() {
//        String colorStr = String.valueOf(exerciseColorTwoL.getValue());
//        Color colorTextClickRED = Color.web("#" + colorStr.substring(2, 8).toUpperCase());
        String colorStr = Integer.toHexString(exerciseColorTwoL.getValue().hashCode()).substring(0, 6).toUpperCase();
        if (colorStr.equalsIgnoreCase("6400ff")){
            Color colorClock = Color.web("#006400");
            return colorClock;
        }
        Color colorTextClickRED = Color.web("#" + colorStr);
        return colorTextClickRED;
    }

    public static Color getColorTextClickPERU() {
//        String colorStr = String.valueOf(counterColorL.getValue());
//        Color colorTextClickPERU = Color.web("#" + colorStr.substring(2, 8).toUpperCase());
        String colorStr = Integer.toHexString(counterColorL.getValue().hashCode()).substring(0, 6).toUpperCase();
        if (colorStr.equalsIgnoreCase("6400ff")){
            Color colorClock = Color.web("#006400");
            return colorClock;
        }
        Color colorTextClickPERU = Color.web("#" + colorStr);
        return colorTextClickPERU;
    }

    public static Color getColorTitle() {
//        String colorStr = String.valueOf(sectionColorL.getValue());
//        Color colorTitle = Color.web("#" + colorStr.substring(2, 8).toUpperCase());

        String colorStr = Integer.toHexString(sectionColorL.getValue().hashCode()).substring(0, 6).toUpperCase();
        if (colorStr.equalsIgnoreCase("6400ff")){
            Color colorClock = Color.web("#006400");
            return colorClock;
        }
        Color colorTitle = Color.web("#" + colorStr);
        return colorTitle;
    }

    public static Color getColorScene() {
//        String colorStr = String.valueOf(sceneColorL.getValue());
//        Color colorScene = Color.web("#" + colorStr.substring(2, 8).toUpperCase());
        String colorStr = Integer.toHexString(sceneColorL.getValue().hashCode()).substring(0, 6).toUpperCase();
        if (colorStr.equalsIgnoreCase("6400ff")){
            Color colorClock = Color.web("#006400");
            return colorClock;
        }
        Color colorScene = Color.web("#" + colorStr);
        return colorScene;
    }

    public static Color getColorClock() {
        String colorStr = Integer.toHexString(timeColorL.getValue().hashCode()).substring(0, 6).toUpperCase();
        if (colorStr.equalsIgnoreCase("6400ff")){
            Color colorClock = Color.web("#006400");
            return colorClock;
        }

//        String colorStr = String.valueOf(timeColorL.getValue());
        Color colorClock = Color.web("#" + colorStr);
//        Color colorClock = Color.web("#" + colorStr.substring(2, 8).toUpperCase());
        return colorClock;
    }
    public static String getColorButton() {
        String colorButton = Integer.toHexString(buttonColorL.getValue().hashCode()).substring(0, 6).toUpperCase();
        if (colorButton.equalsIgnoreCase("6400ff")){
            return "006400";
        }
        return colorButton;
    }
    public static String getIlluminationButton() {
        String colorIllumination = Integer.toHexString(buttonIlluminationL.getValue().hashCode()).substring(0, 6).toUpperCase();
        if (colorIllumination.equalsIgnoreCase("6400ff")){
            return "006400";
        }
        return colorIllumination;
    }

    public static Color getColorTextTITLE() {
        Color colorTextClick = Color.DARKGRAY;
        return colorTextClick;
    }
    public static Color getColorYellow(){
        Color colorYellow = Color.YELLOW;
        return colorYellow;
    }
    public static Color getColorRed(){
        Color colorRed = Color.RED;
        return colorRed;
    }
    public static Color getColorGreen(){
        Color colorGreen = Color.GREEN;
        return colorGreen;
    }
    public static Color getColorBlue(){
        Color colorBlue = Color.BLUE;
        return colorBlue;
    }
    public static Color getColorPurple(){
        Color colorPurple = Color.PURPLE;
        return colorPurple;
    }
    public static Color getColorBlack(){
        Color colorBlack = Color.BLACK;
        return colorBlack;
    }
}
