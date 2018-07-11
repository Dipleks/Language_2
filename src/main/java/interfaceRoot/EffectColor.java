package interfaceRoot;

import db.TableDB;
import javafx.scene.paint.Color;

public class EffectColor implements TableDB, ArgumentsSettings
{
    public static Color getColorText() {
        String colorStr = Integer.toHexString(examColorOneL.getValue().hashCode()).substring(0, 6).toUpperCase();
        System.out.println(colorStr);
        Color colorText = Color.web("#" + colorStr);
        return colorText;
    }

    public static Color getColorTextImpr() {
        String colorStr = Integer.toHexString(examColorTwoL.getValue().hashCode()).substring(0, 6).toUpperCase();
        System.out.println(colorStr);
        Color colorTextImpr = Color.web("#" + colorStr);
        return colorTextImpr;
    }

    public static Color getColorTextClick() {
        String colorStr = Integer.toHexString(exerciseColorOneL.getValue().hashCode()).substring(0, 6).toUpperCase();
        System.out.println(colorStr);
        Color colorTextClick = Color.web("#" + colorStr);
        return colorTextClick;
    }

    public static Color getColorTextClickRED() {
        String colorStr = Integer.toHexString(exerciseColorTwoL.getValue().hashCode()).substring(0, 6).toUpperCase();
        System.out.println(colorStr);
        Color colorTextClickRED = Color.web("#" + colorStr);
        return colorTextClickRED;
    }

    public static Color getColorTextClickPERU() {
        String colorStr = Integer.toHexString(counterColorL.getValue().hashCode()).substring(0, 6).toUpperCase();
        System.out.println(colorStr);
        Color colorTextClickPERU = Color.web("#" + colorStr);
        return colorTextClickPERU;
    }

    public static Color getColorTitle() {
        Color colorTitle = Color.DARKGRAY;
        return colorTitle;
    }

    public static Color getColorScene() {
        Color colorScene = Color.WHITE;
        return colorScene;
    }

    public static Color getColorClock() {
        Color colorClock = Color.DARKGREEN;
        return colorClock;
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
